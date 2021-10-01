<template>
	<view>
		<u-tabs name="cate_name" count="cate_count" :list="tyepList" :is-scroll="false" :current="currentType" @change="onTypeChanged"></u-tabs>
		<emotionHistory></emotionHistory>
		<view >
		<u-table>
			<u-tr>
				<view v-for="item in selectTable.tr">
				<u-th width="200rpx">{{item}}</u-th>
				</view>
			</u-tr>
			<u-tr v-for="item in selectTable.tr">
				<view v-for="item in selectTable.tr">
					<u-td>{{item}}</u-td>
				</view>
			</u-tr>
		</u-table>
		</view>
	</view>
</template>

<script>
	
	import emotionHistory from './emotion-history'
	export default {
		components:{
			emotionHistory
		},
		data() {
			return {
				tyepList: [{cate_name: '视力'}, {cate_name: '眼压'}, {cate_name: '运动'}, {cate_name: '用药'}, {cate_name: '情绪'}],
				currentType: 0,
				history:[],
				tableInfo:[
					{tr:['时间','左眼','右眼','裸眼/矫正']}
				],
				selectTable: {}
			}
		},
		onLoad(options) {
			// if(options && options.history){
			// 	this.history=options.history
			// 	console.log(JSON.stringify(this.history))
			// }
			this.getHistory()
			this.selectTable=this.tableInfo[0]
		},
		methods: {
			onTypeChanged(index) {
				this.currentType = index;
				this.selectTable=this.tableInfo[index]
			},
			getHistory(){
				let userInfo= this.$queue.getData("UserInfo")
				if(userInfo)
				{
					this.$Request.get("/system/record/getInfoById/"+userInfo.userId).then(res=>{
						if(res.code  == 200)
						{
							this.history=res.data
							console.log(JSON.stringify(this.history))
						}
					}).catch(res=>{console.log("getHistory error")})
				}
			},
		}
	}
</script>

<style>
	.container{
		width: 1000rpx;
	}
</style>
