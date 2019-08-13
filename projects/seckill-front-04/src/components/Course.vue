<template>
	<div id="course" v-loading.fullscreen.lock="load"
			 element-loading-text="秒杀排队中"
			 element-loading-background="rgba(0, 0, 0, 0.8)">
			 <!-- 面包屑导航 -->
			 <div>
				<el-breadcrumb separator="/">
					<el-breadcrumb-item to="/home/course/list">Home</el-breadcrumb-item>
					<el-breadcrumb-item to="/home/course/list">Course List</el-breadcrumb-item>
					<el-breadcrumb-item>{{course.courseName}}</el-breadcrumb-item>
				</el-breadcrumb>
			</div>
			<h1>{{ course.courseName }}</h1>
				<!-- 整个第三行的外层 div - 阴影 -->
			<div class="detail">
				<el-row>
					<el-col :span="16" class="detail-left">
						<!-- 左侧底层图片 div -->
						<div class="detail-pic" :style="{background: ' url(' + require('../assets/images/course/' + course.coursePic) + ')'}">
							<!-- 上层蓝色前景色div -->
							<div class="blue-bg">
								<!-- 内容布局 div -->
								<div class="detail-content">
									<!-- 课程名加粗div -->
									<span class="detail-content-text">{{course.courseName}}</span>
										<!-- 倒计时div -->
									<span class="detail-content-timer">{{courseTimerStatus}}</span>
								</div>
								<!-- 播放图标 div -->
								<img class="course-play" src="../assets/images/play.png"/>
			        </div>
			      </div>
					</el-col>
					<el-col :span="8">
						<!-- 右侧课程信息 div -->
						<div class="detail-right">
							<!-- 右上讲师信息 div -->
							<div class="detail-teacher-container">
								<!-- 讲师头像 div -->
								<img src="../assets/images/sam.png"></img> <!-- 讲师姓名 -->
								<span>Instructor: {{course.teacherName}}</span>
							</div>
							<!-- 右下课程信息 div-->
							<div class="detail-info">
								<!-- 报名按钮 -->
								<div>
									<el-button id="book-btn" type="info" v-if="true" ref="book" class="el-button--primary">
										<span>Enroll Now</span>
									</el-button>
									<el-button type="info" v-if="false" class="el-button--primary" id="trun-btn">
										 <span>View Order</span>
									</el-button>
									<el-button type="info" disabled v-if="false">
										<span>Sold Out</span>
									</el-button>
								</div>
								<!-- 课程时间、描述div -->
								<div class="">
									<br/>
									<p>Course ID: {{course.courseNo}}<br/></p>
									<p>Start Time: {{course.startTime | date-format}}<br/></p>
									<p>End time: {{course.endTime | date-format}}<br/><br/></p>
									<p>{{course.courseDesciption}}</p>
              	</div>
            	</div>
	          </div>
	        </el-col>
	      </el-row>
	    </div>
	  </div>
</template>

<script>
export default {
	name: 'course',
	data () {
		return {
			course: {
        "courseNo": "",
        "courseName": "",
        "teacherName": "",
        "courseDesciption": "",
        "coursePeriod": "",
        "startTime": 0,
        "endTime": 0,
        "courcePrice": 0,
        "stockQuantity": 0,
        "courseType": 0,
        "coursePic": ""
      },
			courseTimerStatus: '',
      timer: null,
      isTimerStop: true,
      showButtonType: 0,
      isBookButtonDisabled: false,
      load: false
		}
	},
	created: function() {
		var self = this;
		self.axios.get('/api/courseDetail/' + self.$route.params.courseNo)
			.then(function (response) {
				self.course = response.data.data.course;
				self.checkTimerStatus();
			})
			.catch(function (error) {
				self.$message.error(response)
			})
	},
	methods: {
		checkTimerStatus() {
			var self = this;
			var startTime = new Date(self.course.startTime);
			var endTime = new Date(self.course.endTime);
			var currTime =  new Date();
			// before course started
			if (startTime > currTime) {
				if (self.course.stockQuantity > 0) {
					self.isTimerStop = false;
					self.startTimer()
				} else {
					self.courseTimerStatus = 'sold out';
				}

			} else if (startTime <= currTime && endTime > currTime) { // when course is proceeding
				if (self.course.stockQuantity > 0) {
					self.courseTimerStatus = 'start enroll'
				} else {
					self.courseTimerStatus = 'sold out'
				}
			} else { // when course ended
				self.courseTimerStatus = 'COURSE ENDED'
			}
		},
		startTimer() {
			var self = this;

			self.timer = setInterval(function() {
				if (self.isTimerStop) {
					clearInterval(self.timer)
				}
				self.updateTimer()
			}, 1000)
		},
		updateTimer() {
			var self = this;
			var startTime = new Date(this.course.startTime);
			var currTime =  new Date();
			var leftTime = parseInt((startTime.getTime() - currTime.getTime()) / 1000);
			var days = parseInt(leftTime / (24 * 60 * 60))
			var hours =  parseInt(leftTime / (60 * 60) % 24)
			var mins = parseInt(leftTime / 60 % 60)
			var secs = parseInt(leftTime % 60)
			self.courseTimerStatus = `${days} days ${hours} hours ${mins} minutes ${secs} seconds`
			if (leftTime <= 0) {
				self.isTimerStop = true;
			}
		}
	}
}
</script>

<style lang="css" >
@import '../assets/css/course.css'
</style>
