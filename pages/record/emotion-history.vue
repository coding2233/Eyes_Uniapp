<template>
	<view>
		<label>情绪情绪</label>
		<u-table>
				<u-tr>
					<u-th>日期</u-th>
					<u-th>情绪类型</u-th>
				</u-tr>
				<view v-for="item in outputDatas">
					<u-tr>
						<u-td>{{item.recordTime}}</u-td>
						<u-td>{{item.emotion}}</u-td>
					</u-tr>
				</view>
			</u-table>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				name: 'emotion-history',
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
						let dataEmotion = "-"
						if(recordData.emotion!=""){
							dataEmotion=recordData.emotion
						}
						let data = {recordTime:recordData.recordTime,emotion:dataEmotion}
						this.outputDatas.push(data)
					}
					
				})
			},
		}
	}
</script>

<style>

</style>
