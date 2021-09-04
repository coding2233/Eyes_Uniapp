<template>
	<view class="view">
		<button class="btn" type="primary" @click="changeEye('showModal')">
			<view style="font-size: 48upx;">视力</view>
			<view style="font-size: 30upx;" v-if="lastHistory">
				左眼视力:{{lastHistory.visionLeft}}
				右眼视力:{{lastHistory.visionRight}}
			</view>
			<view style="font-size: 30upx;" v-else>
				暂无历史记录
			</view>
		</button>

		<button class="btn" type="primary" @click="changeEye('showModal1')">
			<view style="font-size: 48upx;">眼压</view>
			<!-- <view style="font-size: 30upx;">{{pressureLeft?('左眼眼压:'+pressureLeft+'右眼眼压:'+pressureRight):"监测数据"}}</view> -->
			<view style="font-size: 30upx;" v-if="lastHistory">
				左眼眼压:{{lastHistory.pressureLeft}}
				右眼眼压:{{lastHistory.pressureRight}}
			</view>
			<view style="font-size: 30upx;" v-else>
				暂无历史记录
			</view>
		</button>
		<button class="btn" type="primary" @click="changeEye('showModal2')">
			<view style="font-size: 48upx;">运动</view>
			<!-- <view style="font-size: 30upx;">{{motion?motion:"(记录运动)"}}</view> -->
			<view style="font-size: 30upx;" v-if="lastHistory">
				{{lastHistory.motion}}
			</view>
			<view style="font-size: 30upx;" v-else>
				暂无历史记录
			</view>
		</button>
		<button class="btn" type="primary" @click="changeEye('showModal3')">
			<view style="font-size: 48upx;">用药</view>
			<!-- <view style="font-size: 30upx;">{{medication?medication:"(记录每日用药及不良反应)"}}</view> -->
			<view style="font-size: 30upx;" v-if="lastHistory">
				{{lastHistory.medication}}
			</view>
			<view style="font-size: 30upx;" v-else>
				暂无历史记录
			</view>
		</button>
		<button class="btn" type="primary" @click="changeEye('showModal4')">
			<view style="font-size: 48upx;">情绪</view>
			<!-- <view style="font-size: 30upx;">{{emotion?emotion:"(记录情绪)"}}</view> -->
			<view style="font-size: 30upx;" v-if="lastHistory">
				{{lastHistory.emotion}}
			</view>
			<view style="font-size: 30upx;" v-else>
				暂无历史记录
			</view>
		</button>
		<button class="btn" type="primary" @click="handleTap('picker1')">
			<view style="font-size: 48upx;">添加记录</view>
		</button>
		<neil-modal :show="showModal" @close="closeModal()" @cancel="cancelModal()" @confirm="confirmModal('showModal')"
			title="请输入视力">
			
			<view>
				<u-subsection :list="visionType" :current="currentVisionType"></u-subsection>
			</view>
			<view class="input-view">
				<view class="input-name">
					<view style="font-size: 32upx;">左眼视力</view>
					<input type="number" v-model="visionLeft" placeholder="请输入左眼视力" />
				</view>
				<view class="input-password">
					<view style="font-size: 32upx;">右眼视力</view>
					<input type="number" v-model="visionRight" placeholder="请输入右眼视力" />
				</view>
			</view>
			<u-section :title="getHistoryTitle()" color="#2979ff" sub-title="查看更多"></u-section>
			
		</neil-modal>
		<neil-modal :show="showModal1" @close="closeModal()" @cancel="cancelModal()"
			@confirm="confirmModal('showModal1')" title="请输入眼压">
			<view style="display: flex; justify-content: center;">
				<u-button @click="OnEyePressure" size="medium">选择日期</u-button>
				<view v-if="eyePressurePickerShow">
					<u-picker mode="time" v-model='eyePressurePickerShow' :params="params"></u-picker>
				</view>
				
			</view>
			<view class="input-view">
				<view class="input-name">
					<view style="font-size: 32upx;">左眼眼压</view>
					<input type="number" v-model="pressureLeft" placeholder="请输入15~18mmHg" />
				</view>
				<view class="input-name">
					<view style="font-size: 32upx;">右眼眼压</view>
					<input type="number" v-model="pressureRight" placeholder="请输入15~18mmHg" />
				</view>
			</view>
			<u-section :title="getHistoryTitle()" color="#2979ff" sub-title="查看更多"></u-section>
		</neil-modal>
		<neil-modal :show="showModal2" @close="closeModal()" @cancel="cancelModal()"
			@confirm="confirmModal('showModal2')" title="请记录运动">
			<view class="input-view">
				<view class="input-name">
					<view style="font-size: 32upx;">运动</view>
					<input v-model="motion" placeholder="请输入最近运动情况" />
				</view>
			</view>
			<u-section :title="getHistoryTitle()" color="#2979ff" sub-title="查看更多"></u-section>
		</neil-modal>
		<neil-modal :show="showModal3" @close="closeModal()" @cancel="cancelModal()"
			@confirm="confirmModal('showModal3')" title="请记录用药情况">
			<view class="input-view">
				<view class="input-name">
					<view style="font-size: 32upx;">用药</view>
					<input v-model="medication" placeholder="请输入用药情况" />
				</view>
			</view>
			<u-section :title="getHistoryTitle()" color="#2979ff" sub-title="查看更多"></u-section>
		</neil-modal>
		<neil-modal :show="showModal4" @close="closeModal()" @cancel="cancelModal()"
			@confirm="confirmModal('showModal4')" title="请记录情绪">
			<view class="input-view">
				<view class="input-name">
					<view style="font-size: 32upx;">情绪</view>
					<input v-model="emotion" placeholder="请记录情绪" />
				</view>
			</view>
			<u-section :title="getHistoryTitle()" color="#2979ff" sub-title="查看更多"></u-section>
		</neil-modal>
		<lb-picker ref="picker1" :default-time-limit="1" v-model="recordTime" mode="dateSelector" :end-date="today" @change="handleChange"
			@confirm="handleConfirm" @cancel="handleCancel">
		</lb-picker>
	</view>
</template>

<script>
	import neilModal from '@/components/neil-modal/neil-modal.vue';
	import LbPicker from '@/components/lb-picker';
	export default {
		components: {
			neilModal,
			LbPicker
		},
		data() {
			return {
				visionLeft: '',
				visionRight: '',
				pressureLeft: '',
				pressureRight: '',
				motion: '',
				medication: '',
				emotion: '',
				recordTime: '',
				showModal: false,
				showModal1: false,
				showModal2: false,
				showModal3: false,
				showModal4: false,
				extraIcon: {
					color: '#4cd964',
					size: '22',
					type: 'gear-filled'
				},
				today: "",
				visionType:[{name:'矫正'},{name:'裸眼'}],
				currentVisionType: 1,
				params: {
					year: true,
					month: true,
					day: true,
					hour: true,
					minute: true,
				},
				eyePressurePickerShow: false,
				history:{},
				lastHistory:null,
			};
		},
		onShow() {
			this.today = this.getTodayDate()
			this.onGetHistory()
		},
		methods: {
			changeEye(e) {
				this[e] = true
			},
			closeModal() {
				this.showModal = false
				this.showModal1 = false
				this.showModal2 = false
				this.showModal3 = false
				this.showModal4 = false
			},
			cancelModal(e) {
				if (e == 'showModal') {
					this.visionLeft = ''
					this.visionRight = ''
				} else if (e == 'showModal1') {
					this.pressureLeft = ''
					this.pressureRight = ''
				} else if (e == 'showModal2') {
					this.motion = ''
				} else if (e == 'showModal3') {
					this.medication = ''
				} else if (e == 'showModal4') {
					this.emotion = ''
				}
			},
			confirmModal(e) {
				if (e == 'showModal') {
					if (!this.visionLeft || !this.visionRight) {
						this.visionLeft = ''
						this.visionRight = ''
						this.$queue.showToast("记录失败！左右眼视力不能为空")
					}

				} else if (e == 'showModal1') {
					if (!this.pressureLeft || !this.pressureRight) {
						this.pressureLeft = ''
						this.pressureRight = ''
						this.$queue.showToast("记录失败！左右眼眼压不能为空")
					}

				}
			},
			handleTap(name) {
				this.$refs[name].show()
			},
			handleChange(e) {
				console.log('change::', e)
			},
			handleConfirm(e) {
				this.recordTime = e.value
				var that = this
				this.$queue.showLoading("正在修改...")
				let param = {
					userId:this.$queue.getData('UserInfo').userId,
					visionLeft: this.visionLeft,
					visionRight: this.visionRight,
					pressureLeft: this.pressureLeft,
					pressureRight: this.pressureRight,
					motion: this.motion,
					medication: this.medication,
					emotion: this.emotion,
					recordTime: this.recordTime,
				}
				console.log(param)
				this.$Request.post("/system/record",
					param
				).then(res => {
					console.log(res)
					uni.hideLoading()
					if (res.code == 200) {
						this.$queue.showToast("记录成功")
						this.visionLeft = ''
						this.visionRight = ''
						this.pressureLeft = ''
						this.pressureRight = ''
						this.motion = ''
						this.emotion = ''
						this.medication = ''
						this.recordTime = ''
					} else {
						this.$queue.showToast(res.msg)

					}
				})

			},
			handleCancel(e) {
				console.log('cancel::', e)
			},
			getTodayDate(){
				let date = new Date()
				var today = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()
				return today
			},
			//视力类型
			// visionTypeChange(evt) {
			// 	 for (let i = 0; i < this.items.length; i++) {
			// 		if (this.items[i].value === evt.detail.value) {
			// 			this.currentVisionType = i;
			// 			break;
			// 		}
			// 	}
			// },
			visionTypeChange(evt){
				console.log('switch1 发生 change 事件，携带值为', evt.target.value)
				this.currentVisionType= evt.target.value
				// visionTypeChange=evt.target.value
			},
			OnEyePressure(){
				console.log(this.eyePressurePickerShow)
				this.eyePressurePickerShow=!this.eyePressurePickerShow;
			},
			onGetHistory(){
				this.lastHistory=null
				let userInfo= this.$queue.getData("UserInfo")
				if(userInfo)
				{
					console.log(userInfo.userId)
					// this.$Request.get("/system/record/list").then(res=>{
					this.$Request.get("/system/record/getInfoById/"+userInfo.userId).then(res=>{
						if(res.code  == 200)
						{
							this.history=res.data
							if(this.history.length>0)
							{
								this.lastHistory=this.history[this.history.length-1]
							}
							// console.log(this.history.length)
						}
					}).catch(res=>{console.log("onGetHistory error")})
				}
				// getData
			},
			getHistoryTitle(){
				let length = this.history.length
				return "历史记录 ("+length+")"
			}
		}
	};
</script>

<style>
	page {
		width: 100%;
		height: 100%;
	}

	.view {
		width: 100%;
		height: 100%;
	}

	.btn {
		width: 80%;
		padding: 2px;
		margin-top: 20px;
		margin-bottom: 20px;
		box-shadow: 0rpx 0rpx 30rpx 0rpx #007AFF;
		background-image: linear-gradient(to right, #007AFF, #007ABB);
	}


	.input-name,
	.input-password {
		height: 80upx;
		width: 100%;
		display: flex;
		flex-direction: row;
		justify-content: center;
		align-items: center;
		position: relative;
		padding-left: 30upx;
		box-sizing: border-box;
	}

	.input-name::after {
		content: " ";
		position: absolute;
		left: 30upx;
		bottom: 0;
		right: 0;
		height: 1px;
		border-top: 1px solid #e5e5e5;
		transform-origin: 0 0;
		transform: scaleY(.5);
	}

	.input-name view,
	.input-password view {
		width: 140upx;
		height: 50upx;
		line-height: 50upx;
		font-size: 28upx;
		color: #333333;
	}

	.input-name input,
	.input-password input {
		flex: 1;
		height: 50upx;
		line-height: 50upx;
	}
</style>
