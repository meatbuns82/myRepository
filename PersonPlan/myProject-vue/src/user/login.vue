<template>
<div>
        <form class="form-signin">
            <img :src="tagSrc" class="mb-4"  alt="" width="72" height="72">
            <h3 class="h3 mb-3 font-weight-normal">Person理财</h3>
            <label for="inputEmail" class="sr-only">邮箱地址</label>
            <input type="text" id="inputEmail" v-model="useracount" class="form-control" placeholder="邮箱地址或账户" required="true" autofocus="">
            <label for="inputPassword" class="sr-only">密码</label>
            <input type="password" id="inputPassword" v-model="password" class="form-control" placeholder="密码" required="true">
            <div class="checkbox mb-3">
                <label>
                <input type="checkbox" value="remember-me"> 记住我
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block"  @click="logins">登陆</button>
             <button class="btn btn-lg btn-primary btn-block"  @click="showDrawer">注册</button>
            <p class="mt-5 mb-3 text-muted">© 2017-2019</p>
        </form>
        <!-- ---------------- -->
        <a-drawer
        title="注册新用户"
        :width="720"
        @close="onClose"
        :visible="visible"
        :wrapStyle="{height: 'calc(100% - 108px)',overflow: 'auto',paddingBottom: '108px'}"
        >
        <a-form :form="form" layout="vertical" hideRequiredMark>
            <a-row :gutter="16">
            <a-col :span="12">
                <a-form-item label="用户名">
                <a-input
                    v-decorator="['username', {
                    rules: [{ required: true, message: '请输入用户名' }]
                    }]"
                    placeholder="请输入用户名"
                />
                </a-form-item>
            </a-col>
            <a-col :span="12">
                <a-form-item label="账户">
                <a-input
                    v-decorator="['usercount', {
                    rules: [{ required: true, message: '请输入账户/邮箱' }]
                    }]"
                    placeholder="请输入账户/邮箱"
                />
                </a-form-item>
            </a-col>
            </a-row>
            <a-row :gutter="16">
                    <a-col :span="12">
                <a-form-item label="登陆密码">
                <a-input
                    v-decorator="['password', {
                    rules: [{ required: true, message: '请输入登陆密码' }]
                    }]"
                    placeholder="请输入登陆密码"
                    type='password'
                />
                </a-form-item>
            </a-col>
            <a-col :span="12">
                <a-form-item label="确认密码">
                <a-input
                    v-decorator="['cpassword', {
                    rules: [{ required: true, message: '确认密码' }]
                    }]"
                    placeholder="确认密码"
                    type='password'
                />
                </a-form-item>
            </a-col>
            </a-row>
            <a-row :gutter="16">
                <a-col :span="12">
                    <a-form-item label="选择身份">
                    <a-select
                        v-decorator="['identify', {
                        rules: [{ required: true, message: '请选择您在校内的身份' }]
                        }]"
                        placeholder="请选择您的身份"
                    >
                        <a-select-option value="jack">白领</a-select-option>
                        <a-select-option value="tom">学生</a-select-option>
                    </a-select>
                    </a-form-item>
                </a-col>
                <a-col :span="12">
                    <a-form-item label="所在城市">
                        <a-input
                            v-decorator="['city', {
                            rules: [{ required: true, message: '输入您所在城市' }]
                            }]"
                            placeholder="输入您所在城市"
                        />
                    </a-form-item>
                 </a-col>
            </a-row>
            <a-row>
                 <a-col :span="12">
                    <a-form-item label="手机号码">
                        <a-input
                            v-decorator="['tel', {
                            rules: [{ required: true, message: '输入您的手机号码' }]
                            }]"
                            placeholder="输入您的手机号码"
                        />
                    </a-form-item>
                 </a-col>   
            </a-row>
        </a-form>
        <div
            :style="{
            position: 'absolute',
            left: 0,
            bottom: 0,
            width: '100%',
            borderTop: '1px solid #e9e9e9',
            padding: '10px 16px',
            background: '#fff',
            textAlign: 'right',
            }"
        >
            <a-button :style="{marginRight: '8px'}" @click="onClose">
            取消
            </a-button>
            <a-button @click="register" type="primary">注册</a-button>
        </div>
        </a-drawer>
</div>
</template>
<script>
import {login} from '../api/login'
import axios from '../utils/request'
    export default{
        data(){
            return { //组件中的data必须是function 
                tagSrc:require('../../imge/bootstrap-solid.svg'),
                useracount:'',
                password:'',
                //注册用户的抽屉
                form: this.$form.createForm(this), 
                visible: false,
            }
        },
        created(){

        },
        methods:{
            //注册抽屉
            showDrawer() {
                this.visible = true;
            },
            onClose() {
                this.visible = false;
            },
            register(info){
                var list = this.form.getFieldsValue()
                if(list.password == list.cpassword){
                    return axios({
                        method: 'POST',
                        url: '/login/register',
                        data: list
                    }).then(res => {
                        console.log(res.data)
                        this.success("注册成功")
                        this.onClose()
                  
                    })
                }else{
                    this.warning("两次输入密码不一致")
                }
           
            },
               //全局提示消息     
            success(messages) {
            
                this.$message.success(messages);
            },
            warning(messages) {
            this.$message.warning(messages);
            },
            logins(){
                const list={}
                if(this.useracount != "" && this.password !=""){
                    list.useracount=this.useracount
                    list.password = this.password
                    //登陆请求
                    login(list).then(res => {
                        this.success(res.data.data)
                        console.log(res.data.data+ '回调函数')
                        this.$router.push({name:"main"})
                    })
                }else{
                    this.warning("用户名或密码不能为空")
                }
            },
        
        }
    }
</script>
<style scoped>
@import '../../css/signin.css';
@import "../../css/bootstrap.css";

    .bd-placeholder-img {
    font-size: 1.125rem;
    text-anchor: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    }
    @media (min-width: 768px) {
        .bd-placeholder-img-lg {
            font-size: 3.5rem;
        }
    }
    .mb-4{
        position: relative;
        left: 35%;
    }
</style>