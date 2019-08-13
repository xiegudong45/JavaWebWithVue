import Vue from 'vue'
import qs from 'qs'

export default {
	state: {
		isLogin: false,
		user: {
			username: ''
		}

	},
	mutations: {
		login (state, payload) {
			state.isLogin = true
			state.user.username = payload.username
		}
	},
	actions: {
		login(context, payload) {debugger;
			return new Promise((resolve, reject) => {
				Vue.axios.post('/api/login', qs.stringify(payload))
					.then(function (response) {
						var result = response.data;
						if (result.code == 200) {
							resolve(response)
							context.commit('login', payload)
						} else {
							reject(response)
						}
					})
					.catch(function (error) {
						var errorData = {
							message: "Server not responding..."
						}
						error.data = errorData
						reject(error)
					});
				context.commit('changeUsername', payload)
			})

		}
	},
	getters: {
		getUsername(state) {
			return state.user.username
		}
	}
}
