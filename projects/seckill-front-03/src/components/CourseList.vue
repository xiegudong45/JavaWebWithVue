<template>
	<div id="course-list">
		<h1>All Courses</h1>
		<el-row class="list-filter">
			<!-- tab 切换 -->
			<el-col>
				<!-- 通过 class 绑定实现切换 -->
				<el-button class="el-button--primary" size="mini" round >All Courses</el-button>
				<el-button class="el-button--text" size="mini" round >Natural Science</el-button>
			 	<el-button class="el-button--text" size="mini" round >Gardening and Planting</el-button>
		 		<el-button class="el-button--text" size="mini" round >Paintings</el-button>
				<el-button class="el-button--text"size="mini" round >Photography</el-button>
			</el-col>
		</el-row>
		<el-row :gutter="30">
			<!-- 单个的卡片列 -->
			<el-col :span="6" v-for="(item, index) in 6"
							:index="index"
							:key="index"
							class=""><!-- 0 == flag || item.courseType == flag ? '' : 'hide' -->
				<!-- card div -->
				<router-link to="/home/course/xxx">
					<div class="course" >
						<!-- img div -->
						<!-- 使用 require 方法请求图片地址实现图片绑定 -->
						<div :style="{background: 'transparent url(' + require('../assets/images/course/c1.jpg') + ') no-repeat scroll center center'}" class="course-img" >
							<!-- time div -->
							<div class="course-date">
								<!-- 使用过滤器实现日期格式化 -->
								<time class="time">2018-06-01 11:11</time>
							</div>
						</div>
						<!-- info div -->
						<div class="course-info">
							<!-- class name div -->
							<div class="course-name">
								Course Name
							</div>
							<!-- teacher name div -->
							<div class="teacher-name">
								Teacher's Name
          		</div>
        		</div>
					</div>
				</router-link>
  		</el-col>
		</el-row>
	</div>
</template>

<script>
import qs from 'qs'
export default {
  name: 'course-list',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
	created: function() {
		var self = this;
		self.axios.get('/api/courseList')
		.then(function (response) {
			self.$message.success('success!')
		})
		.catch(function (error) {
			self.$message.error('Request Error')
		});
	}
}
</script>

<style scoped>
@import '../assets/css/course-list.css';
</style>
