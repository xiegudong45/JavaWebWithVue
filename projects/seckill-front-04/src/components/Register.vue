<template>
	<portal-template>
		<div id="register">
			<el-form label-position="top" label-width="80px" :model="user" ref="userValid" :rules="rules">
			  <el-form-item label="Username" prop="username">
			    <el-input v-model="user.username" placeholder="enter a username"></el-input>
			  </el-form-item>
			  <el-form-item label="Password" prop="password">
			    <el-input v-model="user.password" placeholder="enter a password" type="password"></el-input>
			  </el-form-item>
				<el-form-item label="Confirm Password" prop="repassword">
			    <el-input v-model="user.repassword" placeholder="password" type="password"></el-input>
			  </el-form-item>

		    <el-button type="primary"class="submit-btn" @click="register('userValid')">Register</el-button>
				<router-link to="/login"><el-button type="text" icon="el-icon-back">Back to Login</el-button></router-link>
			</el-form>
		</div>
  </portal-template>
</template>

<script>
import PortalTemplate from './PortalTemplate'
export default {
  name: 'register',
	components: {
		PortalTemplate
	},
  data () {
    return {
			user: {
				username: '',
				password: '',
				repassword: ''
			},
			rules: {
				username: [
					{ required: true, message: 'username cannot be empty', trigger: 'blur' }
				],
				password: [
					{ required: true, message: 'password cannot be empty', trigger: 'blur' }
				],
				repassword: [
					{ required: true, message: 'password cannot be empty', trigger: 'blur' },
					{ validator: (rule, value, callback) => {
		        if (value === '') {
		          callback(new Error('请再次输入密码'));
		        } else if (value !== this.user.password) {
		          callback(new Error('两次输入密码不一致!'));
		        } else {
		          callback();
		        }
		      }, trigger: 'blur' }
				]
			}
    }
  },
	methods: {
		register(formName) {
			var self = this;
			self.$refs[formName].validate((valid) => {
				if (valid) {
					alert("ke yi zhu ce le")
				}
			})
		}
	}
}
</script>

<style lang="scss">
</style>
