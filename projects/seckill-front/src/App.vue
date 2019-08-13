<template>
  <div id="app">
    <img src="./assets/logo.png">
    <h1>{{ msg }}</h1>
    <input v-model="msg" />
	<button @click="changeMsg">Click Me</button>
	<hr/>
	firstname:<input v-model="firstname" /><br/>
	lastname:<input v-model="lastname" /><br/>
  fullname: {{firstname}} &nbsp; {{lastname}}<br/>
	fullname methods: {{getFullname()}}<br/>
	fullname computed: {{ fullnameWatch }}</br>
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
		  type: 'text',
		  firstname: "Shenghao",
		  lastname: "Xie",
			fullnameWatch: 'Shenghao Xie'
    }
	},
	methods: {
		changeMsg() {
			this.msg = 'Shenghao';
		},
		getFullname() {
			return this.firstname + " " + this.lastname;
		}
	},
	watch: {
		firstname: function(val) {
			this.fullnameWatch = val + " " + this.lastname;
		},
		lastname: function(val) {
			this.fullnameWatch = this.firstname + " " + val;
		}
	}
}
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
