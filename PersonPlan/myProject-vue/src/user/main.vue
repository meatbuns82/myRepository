<template>
  <a-layout id="components-layout-demo-side" style="min-height: 100vh">
    <a-layout-sider collapsible v-model="collapsed">
      <div class="logo" />
      <a-menu theme="dark" :defaultSelectedKeys="['1']" mode="inline">
        <a-menu-item key="1">
          <a-icon type="pie-chart" />
          <router-link to="order" tag="span">首页</router-link>
        </a-menu-item>
        <a-sub-menu key="sub1">
          <span slot="title"><a-icon type="form" /><span>记账</span></span>
          <a-menu-item key="2">月入帐</a-menu-item>
          <a-menu-item key="3">月出账</a-menu-item>
          <a-menu-item key="4">日入账</a-menu-item>
          <a-menu-item key="5">日出账</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub2">
          <span slot="title"><a-icon type="snippets" /><span>理财计划</span></span>
          <a-menu-item key="6">当月消费图表</a-menu-item>
          <a-menu-item key="7">当月收支比例表</a-menu-item>
        </a-sub-menu>
        <a-menu-item key="8">
          <a-icon type="dollar" />
          <router-link to="order" tag="span">年度账单</router-link>
        </a-menu-item>
        <a-sub-menu key="sub3">
          <span slot="title"><a-icon type="money-collect" /><span>利率分析</span></span>
          <a-menu-item key="9">各银行存款利率</a-menu-item>
          <a-menu-item key="10">稳定理财的利率信息</a-menu-item>
          <a-menu-item key="11">近三年最稳定股票前十</a-menu-item>
        </a-sub-menu>
         <a-sub-menu key="sub4">
          <span slot="title"><a-icon type="property-safety" /><span>理财风险分析</span></span>
          <a-menu-item key="12">用户交流</a-menu-item>
          <a-menu-item key="13">平台分析</a-menu-item>
          <a-menu-item key="14">认证分析</a-menu-item>
        </a-sub-menu>
        <a-menu-item key="15">
          <a-icon type="edit" />
          <span>记账记录</span>
        </a-menu-item>
        <a-menu-item key="16">
          <a-icon type="file" />
          <span>理财备忘录</span>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-header style="background: #fff; padding: 0" />
      <a-layout-content style="margin: 0 16px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>用户</a-breadcrumb-item>
          <a-breadcrumb-item>Bill</a-breadcrumb-item>
        </a-breadcrumb>
        <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">
            <router-view></router-view>
        </div>
      </a-layout-content>
      <a-layout-footer style="text-align: center">
        Person理财 ©2018 路文华 2019/12/3
      </a-layout-footer>
    </a-layout>
  </a-layout>
</template>
<script>
  export default {
    data() {
      return {
        collapsed: false,
      };
    },
    created(){

    },
    methods:{

    }
};
</script>

<style>
  #components-layout-demo-side .logo {
    height: 32px;
    background: rgba(255, 255, 255, 0.2);
    margin: 16px;
  }
</style>