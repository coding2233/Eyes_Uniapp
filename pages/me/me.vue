<template>
	<view>
		<view class="person-head">
			<cmd-avatar
				:src="avatar"
				size="lg" :make="{'background-color': '#fff'}"></cmd-avatar>
			<view class="person-head-box">
				<view class="person-head-nickname">{{userInfo.nickName}}</view>
				<view class="person-head-username">ID：{{userInfo.userId}}</view>
			</view>
		</view>
		<p style="margin-left: 20rpx;">基本信息</p>
		<view class="person-list">
			<cmd-cell-item @click="sexShow=true" title="性别" :addon="userInfo.sex?userInfo.sex:'男'" slot-left arrow>
				<cmd-icon type="user" size="24" color="#368dff"></cmd-icon>
			</cmd-cell-item>
			<cmd-cell-item @click="birthdayShow=true" title="生日" :addon="userInfo.birthday?userInfo.birthday.substring(0,7):''" slot-left arrow>
				<cmd-icon type="money" size="24" color="#368dff"></cmd-icon>
			</cmd-cell-item>
			<cmd-cell-item @click="cityShow=true" title="所在城市" :addon="userInfo.city" slot-left arrow>
				<cmd-icon type="tag" size="24" color="#368dff"></cmd-icon>
			</cmd-cell-item>
		</view>
		<p style="margin-left: 20rpx;margin-top: 40rpx;">青光眼情况</p>
		<view class="person-list">
			<cmd-cell-item @click="eyesTypeShow=true" title="青光眼类型" :addon="userInfo.eyesType?userInfo.eyesType:''" slot-left arrow>
				<cmd-icon type="image" size="24" color="#368dff"></cmd-icon>
			</cmd-cell-item>
			<cmd-cell-item @click="cornerShow=true" title="房角" :addon="userInfo.corner?userInfo.corner:''" slot-left arrow>
				<cmd-icon type="image" size="24" color="#368dff"></cmd-icon>
			</cmd-cell-item>
			<cmd-cell-item @click="familyShow=true" title="家族史" :addon="userInfo.history?userInfo.history:'无'" slot-left arrow>
				<cmd-icon type="alert-circle" size="24" color="#368dff"></cmd-icon>
			</cmd-cell-item>
			<cmd-cell-item @click="diagnosisShow=true" title="确诊日期"  :addon="userInfo.diagnosis?userInfo.diagnosis:''" slot-left arrow>
				<cmd-icon type="message" size="24" color="#368dff"></cmd-icon>
			</cmd-cell-item>
			<!-- <cmd-cell-item @click="toArchives()" title="我的青光眼档案" slot-left arrow>
				<cmd-icon type="clock" size="24" color="#368dff"></cmd-icon>
			</cmd-cell-item> -->
		<!-- 	<cmd-cell-item @click="fnInfoWin" title="个人设置" slot-left arrow>
				<cmd-icon type="settings" size="24" color="#368dff"></cmd-icon>
			</cmd-cell-item> -->
		</view>
		<u-picker mode="selector" v-model="familyShow" :range='["有","无"]' @confirm="onFamilySelected"></u-picker>
		<u-picker mode="selector" v-model="eyesTypeShow" :range='["儿童青光眼","原发性青光眼","继发性青光眼","混合型青光眼"]' @confirm="oneEyesTypeSelected"></u-picker>
		<u-picker mode="selector" v-model="cornerShow" :range='["开角型","闭角型"]' @confirm="onCornerSelected"></u-picker>
		<u-picker mode="time" v-model="birthdayShow" :params='{year:true,month:true}' @confirm="onbirthdaySelected"></u-picker>
		<u-picker mode="time" v-model="diagnosisShow" @confirm="ondiagnosisSelected"></u-picker>
		<u-picker mode="selector" v-model="sexShow" :range='["男","女"]' @confirm="onSexSelected"></u-picker>
		<u-picker mode="region" v-model="cityShow" @confirm="onCitySelected"></u-picker>
	</view>
</template>

<script>
	import cmdAvatar from "@/components/cmd-avatar/cmd-avatar.vue"
	import cmdIcon from "@/components/cmd-icon/cmd-icon.vue"
	import cmdCellItem from "@/components/cmd-cell-item/cmd-cell-item.vue"

	export default {
		components: {
			cmdAvatar,
			cmdCellItem,
			cmdIcon
		},
		onLoad() {
			// this.getUserInfo()
			// this.loadData()
		},
		onShow() {
			this.getUserInfo()
		},
		// onReady(){
		// 	this.getUserInfo()
		// },
		data() {
			return {
				userInfo: {},
				avatar: '',
				familyShow:false,
				eyesTypeShow:false,
				cornerShow:false,
				birthdayShow:false,
				diagnosisShow:false,
				sexShow:false,
				cityShow:false,
			};
		},
		methods: {
			loadData() {
				this.userInfo = this.$queue.getData('UserInfo')
				this.avatar="../../static/img/me/icon.boy.png"
				if (this.userInfo.sex=='女') {
					this.avatar="../../static/img/me/girl.png"
					// this.avatar = 'http://localhost:8080' + this.userInfo.avatar
				}
			},
			getUserInfo() {
				console.log("Me get user info.")
				this.$Request.get('/getInfo').then(f => {
					console.log("f "+JSON.stringify(f))
					if (f.code == 200) {
						if(f.userInfo)
						{
							let userInfo=f.userInfo
							this.$queue.setData("UserInfo", userInfo)
							this.loadData()
							console.log(f.msg)
							this.$forceUpdate()
						}
					}
					else
					{
						console.log("getInfo faile.")
					}
				})
			},
			toArchives(){
				uni.navigateTo({
					url:'../archives/archives'
				})
			},
			/**
			 * 打开用户信息页
			 */
			fnInfoWin() {
				uni.navigateTo({
					url: '/pages/me/info/info'
				})
			},
			onFamilySelected(e){
				this.userInfo.history= e==0?"有":"无"
				this.updateUserInfo()
			},
			oneEyesTypeSelected(e){
				let ets = ["儿童青光眼","原发性青光眼","继发性青光眼","混合型青光眼"]
				this.userInfo.eyesType=ets[e]
				this.updateUserInfo()
			},
			onCornerSelected(e){
				let ets = ["开角型","闭角型"]
				this.userInfo.corner=ets[e]
				this.updateUserInfo()
			},
			onbirthdaySelected(e){
				this.userInfo.birthday=e.year+'-'+e.month+"-01"
				this.updateUserInfo()
			},
			ondiagnosisSelected(e){
				this.userInfo.diagnosis=e.year+'-'+e.month+"-"+e.day
				this.updateUserInfo()
			},
			onCitySelected(city){
				this.userInfo.city = city.province.label + '-' + city.city.label + '-' + city.area.label;
				this.updateUserInfo()
			},
			onSexSelected(sex)
			{
				this.userInfo.sex=sex==0?"男":"女"
				this.updateUserInfo()
			},
			updateUserInfo()
			{
				console.log("put userinfo: "+JSON.stringify(this.userInfo))
				this.$Request.put("/system/info",this.userInfo).then(
					sir=>{
						console.log("put /system/info "+JSON.stringify(sir))
						if(sir.code==200)
						{
							uni.showToast({
								icon: "none",
								title:"个人信息更新成功"
							})
						}
					
					}
				)
			},
		}
	}
</script>

<style>
	.person-head {
		display: flex;
		flex-direction: row;
		align-items: center;
		height: 150px;
		padding-left: 20px;
		background: linear-gradient(to right, #007AFF, #365fff);
	}

	.person-head-box {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: flex-start;
		margin-left: 10px;
	}

	.person-head-nickname {
		font-size: 18px;
		font-weight: 500;
		color: #fff;
	}

	.person-head-username {
		font-size: 14px;
		font-weight: 500;
		color: #fff;
	}

	.person-list {
		line-height: 0;
	}
</style>
