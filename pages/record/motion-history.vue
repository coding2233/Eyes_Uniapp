<template>
	<view>
		<u-table>
				<u-tr>
					<u-th>时间</u-th>
					<u-th>类型</u-th>
					<u-th>时长</u-th>
					<u-th>备注</u-th>
				</u-tr>
				<view v-for="item in outputDatas">
					<u-tr>
						<u-td>{{item.recordTime}}</u-td>
						<u-td>{{item.motion}}</u-td>
						<u-td>{{item.duration}}</u-td>
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
						let dataMotion="-"
						if(recordData.motion!=""){
							dataMotion=recordData.motion
						}
						let data = {recordTime:recordData.recordTime,motion:dataMotion,duration:"29.99 min",remark:"x"}
						this.outputDatas.push(data)
					}
					
				})
			},
		}
	}
</script>

<style>

</style>
