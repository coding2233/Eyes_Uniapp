<template>
	<view>
		<u-table>
				<u-tr>
					<u-th>时间</u-th>
					<u-th>左眼</u-th>
					<u-th>右眼</u-th>
					<u-th>裸眼/矫正</u-th>
				</u-tr>
				<view v-for="item in outputDatas">
					<u-tr>
						<u-td>{{item.recordTime}}</u-td>
						<u-td>{{item.visionLeft}}</u-td>
						<u-td>{{item.visionRight}}</u-td>
						<u-td>{{item.visionType}}</u-td>
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
						let data = {recordTime:recordData.recordTime,visionLeft:recordData.visionLeft,visionRight:recordData.visionRight,visionType:"裸眼"}
						this.outputDatas.push(data)
					}
					
				})
			},
		}
	}
</script>

<style>

</style>
