<template>
  <div id="app">
    app
		<router-link to="/foo">Go to foo</router-link>
		<router-link to="/bar">Go to bar</router-link>

		<button @click="gotoByUrl('/foo')">Go to Foo</button>
		<button @click="gotoByUrl('/bar')">Go to Bar</button>

		<router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
	methods: {
		gotoByUrl(url) {
			this.$router.push(url)
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
