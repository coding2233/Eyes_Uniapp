<template>
	<view>
		<u-table>
				<u-tr>
					<u-th>用药时间</u-th>
					<u-th>药品名</u-th>
					<u-th>频次</u-th>
					<u-th>不良反应</u-th>
					<u-th>停药时间</u-th>
					<u-th>备注</u-th>
				</u-tr>
				<view v-for="item in outputDatas">
					<u-tr>
						<u-td>{{item.recordTime}}</u-td>
						<u-td>{{item.medication}}</u-td>
						<u-td>{{item.frequency}}</u-td>
						<u-td>{{item.adr}}</u-td>
						<u-td>{{item.suspend}}</u-td>
						<u-td>{{item.remark}}</u-td>
					</u-tr>
				</view>
			</u-table>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				outputDatas:[]
			}
		},
		onShow() {
			this.loadData()
		},
		methods: {
			loadData(){
				this.outputDatas=[]
				let userId = this.$queue.getData('UserInfo').userId
				this.$Request.get("/system/record/getInfoById/"+userId).then(res =>{
					// console.log(JSON.stringify(res))
					let dataLength = res.data.length
					for(let i=0;i<dataLength;i++){
						let recordData= res.data[i]
						let data = {recordTime:recordData.recordTime,medication:recordData.medication,frequency:-1,adr:"无",suspend:"1997-01-01",remark:"-"}
						this.outputDatas.push(data)
					}
					
				})
			},
		}
	}
</script>

<style>

</style>
