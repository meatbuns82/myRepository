//整个项目的入口函数
//在这里导入其他文件，html页面就只用导入该文件
//ES6语法高级，浏览器无法解析 用webpack 打包 处理 使用import 要将main.js使用webpack命令打包，在html页面中引入打包后的js文件
//代码打包的时候，如果改动了代码就需要重新打包这样就会非常麻烦 即使通过webpacl.config.js配置简化了打包命令
//此时需要 webpack-dev-server来实现自动打包编译的功能c\
import $ from 'jquery'
import Antd from 'ant-design-vue'


//要解析 .vue文件要安装loader vue-loader vue-template-compiler -D
import { Button, message } from 'ant-design-vue';
import VCharts from 'v-charts' //导入图表
import app from './App.vue'
import Vue from 'vue' //这种方式导入的vue是不完整的，使用其他的组件时，需要单独导入
//到如vue的路由组件

import router from './route/router'
import 'ant-design-vue/dist/antd.css';
Vue.use(Antd)
Vue.use(VCharts)
Vue.use(Button);
Vue.config.productionTip = false;
Vue.prototype.$message = message;
message.config({
  top: `10px`,
  duration: 2,
  maxCount: 1,
});
var vm = new Vue({
    el:'#app',
    data:{
        msg:'main.js'
    },
    methods:{

    },
    components:{
        //login
    },
    router,
    render:c => c(app)
})
//boootstrap



