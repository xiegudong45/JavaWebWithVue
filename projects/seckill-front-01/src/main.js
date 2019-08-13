import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'

// import js
import routes from './js/router/routes'

Vue.use(VueRouter)

const router = new VueRouter({
	mode: 'history',
	routes
})

new Vue({
	router,
  el: '#app',
  render: h => h(App)
})
