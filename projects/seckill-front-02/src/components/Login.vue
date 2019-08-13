<template>
	<portal-template>
		<div id="login">
			<el-form label-position="top" label-width="80px" :model="user" ref="userValid" :rules="rules">
			  <el-form-item label="Username" prop="username">
			    <el-input v-model="user.username" placeholder="username"></el-input>
			  </el-form-item>
			  <el-form-item label="Password" prop="password">
			    <el-input v-model="user.password" placeholder="password" @keypress.enter.native="login('userValid')" type="password"></el-input>
			  </el-form-item>
		    <el-button type="primary"class="submit-btn" @click="login('userValid')">Login</el-button>
				<router-link to="/register"><el-button type="text" icon="el-icon-edit">Register</el-button></router-link>
			</el-form>
		</div>
  </portal-template>
</template>

<script>
import PortalTemplate from './PortalTemplate'
export default {
  name: 'login',
	components: {
    PortalTemplate
  },
  data () {
    return {
			user: {
				username: '',
				password: ''
			},
			rules: {
				username: [
					{ required: true, message: 'username cannot be empty', trigger: 'blur' }
				],
				password: [
					{ required: true, message: 'password cannot be empty', trigger: 'blur' }
				],
			}
    }
  },
	methods: {
		login(formName) {
			var self = this;
			self.$refs[formName].validate((valid) => {
				if (valid) {
					self.$store.dispatch('login', {username: self.user.username, password: self.user.password})
					.then((response) => {
						self.$message.success(response.data.message);
						self.$router.push('/foo');
					})
					.catch((response) => {
						self.$message.error(response.data.message)
					})
				} else {
					console.log('error submit!!');
					alert('error submit!');
					return false;
				}
			})
		}
	}
}
</script>

<style lang="scss">

</style>
