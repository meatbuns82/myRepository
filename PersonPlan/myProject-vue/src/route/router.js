import Vue from 'vue' //这种方式导入的vue是不完整的，使用其他的组件时，需要单独导入
import VueRouter from 'vue-router'
Vue.use(VueRouter)
import login from '../user/login.vue'
import mainVue from '../user/main.vue'
import user from '../user/user.vue'
import order from '../user/order.vue'


const router = new VueRouter({
    routes:[
        {path:'/',component:login},
        {path:'/login',component:login},
        {name:'main', path:'/main',component:mainVue,redirect:'/order',
        children:[
            {path:'/',component:order},
            {path:'/order',component:order},
        ]},
        {path:'/user',component:user},
        {path:'/order',component:order}
    ]
})

export default router