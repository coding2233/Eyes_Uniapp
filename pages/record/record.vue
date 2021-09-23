<template>
	<view class="formContainer">
		<u-form :model="form" ref="uForm">
				<u-form-item label="视力类别" label-width="150">
					<u-input v-model="form.visionType" type="select" placeholder="请选择视力类别" :select-open="visiontypeListShow" @click="visiontypeListShow = true"/>
				</u-form-item>
				<u-form-item label="左眼视力" label-width="150"><u-input v-model="form.visionLeft" /></u-form-item>
				<u-form-item label="右眼视力" label-width="150"><u-input v-model="form.visionRight" /></u-form-item>
				<u-form-item label="左眼眼压" label-width="150"><u-input v-model="form.pressureLeft" /></u-form-item>
				<u-form-item label="右眼眼压" label-width="150"><u-input v-model="form.pressureRight" /></u-form-item>
				<u-form-item label="测量时间" label-width="150"><u-input v-model="form.name" /></u-form-item>
				<u-form-item label="运动类型" label-width="150"><u-input v-model="form.name" type="select" /></u-form-item>
				<u-form-item label="运动时长" label-width="150"><u-input v-model="form.name" /></u-form-item>
				<u-form-item label="运动备注" label-width="150"><u-input v-model="form.name" /></u-form-item>
				<u-form-item label="用药名称" label-width="150"><u-input v-model="form.name" /></u-form-item>
				<u-form-item label="用药时刻" label-width="150"><u-input v-model="form.name" /></u-form-item>
				<u-form-item label="不良反应" label-width="150"><u-input v-model="form.name" /></u-form-item>
				<u-form-item label="停药时刻" label-width="150"><u-input v-model="form.name" /></u-form-item>
				<u-form-item label="用药备注" label-width="150"><u-input v-model="form.name" /></u-form-item>
				<u-form-item label="情绪类型" label-width="150"><u-input v-model="form.name" /></u-form-item>
				<u-form-item label="记录日期" label-width="150"><u-input v-model="form.name" /></u-form-item>
			</u-form>
			<u-gap height="20"></u-gap>
			<u-section title="历史记录 (99+)" color="#2979ff" sub-title="查看更多" @click="selectHistory"></u-section>
			<u-gap height="20"></u-gap>
			<u-button @click="submit">提交</u-button>

			<u-select @confirm="selectVisionTypeConfirm" v-model="visiontypeListShow" :list="visiontypeList"></u-select>
			
	</view>
</template>

<script>
export default {
	data() {
		return {
			form: {
				visionType: '',
				visionLeft: '',
				visionRight: '',
				pressureLeft: '',
				pressureRight: '',
				name: '',
			},
			
			visiontypeList: [
				{label:'矫正',value:0},
				{label:'裸眼',value:1},
				],
				
			visiontypeListShow: false,
			
		};
	},
	
	methods: {
		selectVisionTypeConfirm(e) {
			if(e){
				this.form.visionType=e.label
			}
		},
		
		submit() {
			console.log("提交记录")
		},
		selectHistory() {
			console.log("选择历史记录")
		},
	},
};
</script>

<style>
.formContainer {
	margin-left: 20rpx;
	margin-right: 20rpx;
}
.formLabel {
	width: 200rpx;
}
</style>
