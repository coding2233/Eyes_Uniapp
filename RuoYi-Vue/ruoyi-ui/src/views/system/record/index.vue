<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="左眼视力" prop="visionLeft">
        <el-input
          v-model="queryParams.visionLeft"
          placeholder="请输入左眼视力"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="右眼视力" prop="visionRight">
        <el-input
          v-model="queryParams.visionRight"
          placeholder="请输入右眼视力"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="左眼压力" prop="pressureLeft">
        <el-input
          v-model="queryParams.pressureLeft"
          placeholder="请输入左眼压力"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="右眼压力" prop="pressureRight">
        <el-input
          v-model="queryParams.pressureRight"
          placeholder="请输入右眼压力"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="记录日期" prop="recordTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.recordTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择记录日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="运动记录" prop="medication">
        <el-input
          v-model="queryParams.medication"
          placeholder="请输入运动记录"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="运动情况" prop="emotion">
        <el-input
          v-model="queryParams.emotion"
          placeholder="请输入运动情况"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="情绪状况" prop="motion">
        <el-input
          v-model="queryParams.motion"
          placeholder="请输入情绪状况"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:record:remove']"
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
          v-hasPermi="['system:record:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="recordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="记录编号" align="center" prop="recordId" />
      <el-table-column label="左眼视力" align="center" prop="visionLeft" />
      <el-table-column label="右眼视力" align="center" prop="visionRight" />
      <el-table-column label="左眼压力" align="center" prop="pressureLeft" />
      <el-table-column label="右眼压力" align="center" prop="pressureRight" />
      <el-table-column label="记录日期" align="center" prop="recordTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.recordTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="运动记录" align="center" prop="medication" />
      <el-table-column label="运动情况" align="center" prop="emotion" />
      <el-table-column label="情绪状况" align="center" prop="motion" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:record:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:record:remove']"
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

    <!-- 添加或修改记录信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="左眼视力" prop="visionLeft">
          <el-input v-model="form.visionLeft" placeholder="请输入左眼视力" />
        </el-form-item>
        <el-form-item label="右眼视力" prop="visionRight">
          <el-input v-model="form.visionRight" placeholder="请输入右眼视力" />
        </el-form-item>
        <el-form-item label="左眼压力" prop="pressureLeft">
          <el-input v-model="form.pressureLeft" placeholder="请输入左眼压力" />
        </el-form-item>
        <el-form-item label="右眼压力" prop="pressureRight">
          <el-input v-model="form.pressureRight" placeholder="请输入右眼压力" />
        </el-form-item>
        <el-form-item label="记录日期" prop="recordTime">
          <el-date-picker clearable size="small"
            v-model="form.recordTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择记录日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="运动记录" prop="medication">
          <el-input v-model="form.medication" placeholder="请输入运动记录" />
        </el-form-item>
        <el-form-item label="运动情况" prop="emotion">
          <el-input v-model="form.emotion" placeholder="请输入运动情况" />
        </el-form-item>
        <el-form-item label="情绪状况" prop="motion">
          <el-input v-model="form.motion" placeholder="请输入情绪状况" />
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
import { listRecord, getRecord, delRecord, addRecord, updateRecord, exportRecord } from "@/api/system/record";

export default {
  name: "Record",
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
      // 记录信息表格数据
      recordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        visionLeft: null,
        visionRight: null,
        pressureLeft: null,
        pressureRight: null,
        recordTime: null,
        medication: null,
        emotion: null,
        motion: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {

    console.log( this.queryParams.userId)
    this.getList();
  },
  methods: {
    /** 查询记录信息列表 */
    getList() {
      this.loading = true;
      this.queryParams.userId=this.$route.query.userId
      listRecord(this.queryParams).then(response => {
        this.recordList = response.rows;
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
        recordId: null,
        userId: null,
        visionLeft: null,
        visionRight: null,
        pressureLeft: null,
        pressureRight: null,
        recordTime: null,
        medication: null,
        emotion: null,
        motion: null
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
      this.ids = selection.map(item => item.recordId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加记录信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const recordId = row.recordId || this.ids
      getRecord(recordId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改记录信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.recordId != null) {
            updateRecord(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRecord(this.form).then(response => {
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
      const recordIds = row.recordId || this.ids;
      this.$confirm('是否确认删除记录信息编号为"' + recordIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delRecord(recordIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有记录信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportRecord(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        })
    }
  }
};
</script>
