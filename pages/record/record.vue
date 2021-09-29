<template>
	<view class="formContainer">
		<u-form :model="form" ref="uForm">
				<u-form-item label="视力类别" label-width="150">
					<u-input v-model="form.visionType" type="select" placeholder="请选择视力类别" :select-open="visiontypeListShow" @click="visiontypeListShow = true"/>
				</u-form-item>
				<u-form-item label="左眼视力" label-width="150" >
					<u-input v-model="form.visionLeft" type="float" placeholder="请输入视力" />
				</u-form-item>
				<u-form-item label="右眼视力" label-width="150">
					<u-input v-model="form.visionRight" type="float" placeholder="请输入视力" />
				</u-form-item>
				<u-form-item label="左眼眼压" label-width="150">
					<u-input v-model="form.pressureLeft" type="float" placeholder="请输入眼压" />
				</u-form-item>
				<u-form-item label="右眼眼压" label-width="150">
					<u-input v-model="form.pressureRight" type="float" placeholder="请输入眼压" />
				</u-form-item>
				<u-form-item label="眼压测量时间" label-width="180">
					<u-input v-model="form.pressureTime" type="select" placeholder="请选择测量时间" />
				</u-form-item>
				<u-form-item label="运动类型" label-width="150">
					<u-input v-model="form.motion" type="select" placeholder="请选择运动类型" />
				</u-form-item>
				<u-form-item label="运动时长" label-width="150">
					<u-input v-model="form.motionDuration" placeholder="请输入运动时长" />
				</u-form-item>
				<u-form-item label="运动备注" label-width="150">
					<u-input v-model="form.motionRemark" placeholder="请填写运动备注" />
				</u-form-item>
				<u-form-item label="用药名称" label-width="150">
					<u-input v-model="form.medication" placeholder="请输入用药名称" />
				</u-form-item>
				<u-form-item label="用药时刻" label-width="150">
					<u-input v-model="form.medicationMoment" placeholder="请选择用药时刻" type="select" />
				</u-form-item>
				<u-form-item label="不良反应" label-width="150">
					<u-input v-model="form.medicationAdr" placeholder="请输入不良反应" />
				</u-form-item>
				<u-form-item label="停药时刻" label-width="150">
					<u-input v-model="form.medicationSuspend" placeholder="请选择停药时刻" type="select" />
				</u-form-item>
				<u-form-item label="用药备注" label-width="150">
					<u-input v-model="form.medicationRemark" placeholder="请输入用药备注" />
				</u-form-item>
				<u-form-item label="情绪类型" label-width="150">
					<u-input v-model="form.emotion" placeholder="请输入情绪类型" />
				</u-form-item>
				<u-form-item label="记录日期" label-width="150">
					<u-input v-model="form.recordTime" placeholder="请选择记录日期" type="select" />
				</u-form-item>
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
				pressureTime: '',
				motion:'',
				motionDuration:'',
				motionRemark:'',
				medication:'',
				medicationMoment:'',
				medicationAdr:'',
				medicationSuspend:'',
				medicationRemark:'',
				emotion:'',
				recordTime:''
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
				if(e.length>0){
					this.form.visionType=e[0].label
				}
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
