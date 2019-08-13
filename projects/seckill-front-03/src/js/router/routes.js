import Foo from '../../components/Foo.vue'
import Bar from '../../components/Bar.vue'
import Login from '../../components/Login.vue'
import Register from '../../components/Register.vue'
import HomeTemplate from '../../components/HomeTemplate'
import CourseList from '../../components/CourseList'
import OrderList from '../../components/OrderList'
import Course from '../../components/Course'


export default [
	{ path: '/', component: Login },
	{ path: '/foo', component: Foo },
	{ path: '/bar', component: Bar },
	{ path: '/login', component: Login },
	{ path: '/register', component: Register },
	{ path: '/home', component: HomeTemplate,
		children: [
			{path: 'course/list', component: CourseList},
			{path: 'order/list', component: OrderList},
			{path: 'course/:courseNo', component: Course},
		]
 	}
]
