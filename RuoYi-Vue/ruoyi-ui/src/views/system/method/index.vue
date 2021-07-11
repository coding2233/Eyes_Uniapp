<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="药品" prop="drugs">
        <el-input
          v-model="queryParams.drugs"
          placeholder="请输入药品"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="药物治疗开始时间" prop="drugsStartTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.drugsStartTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择药物治疗开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="药物治疗结束时间" prop="drugsEndTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.drugsEndTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择药物治疗结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="激光治疗" prop="laser">
        <el-input
          v-model="queryParams.laser"
          placeholder="请输入激光治疗"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="激光治疗时间" prop="laserTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.laserTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择激光治疗时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="手术治疗术式" prop="operation">
        <el-input
          v-model="queryParams.operation"
          placeholder="请输入手术治疗术式"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手术治疗时间" prop="operationTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.operationTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择手术治疗时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:method:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
		  :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['system:method:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="methodList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="方式编号" align="center" prop="methodId" />
      <el-table-column label="药品" align="center" prop="drugs" />
      <el-table-column label="药物治疗开始时间" align="center" prop="drugsStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.drugsStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="药物治疗结束时间" align="center" prop="drugsEndTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.drugsEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="激光治疗" align="center" prop="laser" />
      <el-table-column label="激光治疗时间" align="center" prop="laserTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.laserTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="手术治疗术式" align="center" prop="operation" />
      <el-table-column label="手术治疗时间" align="center" prop="operationTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.operationTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="其他治疗方式" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:method:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:method:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改就诊记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="药品" prop="drugs">
          <el-input v-model="form.drugs" placeholder="请输入药品" />
        </el-form-item>
        <el-form-item label="药物治疗开始时间" prop="drugsStartTime">
          <el-date-picker clearable size="small"
            v-model="form.drugsStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择药物治疗开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="药物治疗结束时间" prop="drugsEndTime">
          <el-date-picker clearable size="small"
            v-model="form.drugsEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择药物治疗结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="激光治疗" prop="laser">
          <el-input v-model="form.laser" placeholder="请输入激光治疗" />
        </el-form-item>
        <el-form-item label="激光治疗时间" prop="laserTime">
          <el-date-picker clearable size="small"
            v-model="form.laserTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择激光治疗时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="手术治疗术式" prop="operation">
          <el-input v-model="form.operation" placeholder="请输入手术治疗术式" />
        </el-form-item>
        <el-form-item label="手术治疗时间" prop="operationTime">
          <el-date-picker clearable size="small"
            v-model="form.operationTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择手术治疗时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他治疗方式" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入其他治疗方式" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMethod, getMethod, delMethod, addMethod, updateMethod, exportMethod } from "@/api/system/method";

export default {
  name: "Method",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 就诊记录表格数据
      methodList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: this.$route.query.userId,
        drugs: null,
        drugsStartTime: null,
        drugsEndTime: null,
        laser: null,
        laserTime: null,
        operation: null,
        operationTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.queryParams.userId=this.$route.query.userId
    this.getList();
  },
  methods: {
    /** 查询就诊记录列表 */
    getList() {
      this.loading = true;
      listMethod(this.queryParams).then(response => {
        this.methodList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        methodId: null,
        userId: null,
        drugs: null,
        drugsStartTime: null,
        drugsEndTime: null,
        laser: null,
        laserTime: null,
        operation: null,
        operationTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.methodId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加就诊记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const methodId = row.methodId || this.ids
      getMethod(methodId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改就诊记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.methodId != null) {
            updateMethod(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMethod(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const methodIds = row.methodId || this.ids;
      this.$confirm('是否确认删除就诊记录编号为"' + methodIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delMethod(methodIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有就诊记录数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportMethod(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        })
    }
  }
};
</script>
