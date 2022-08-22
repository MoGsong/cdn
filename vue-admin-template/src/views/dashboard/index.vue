<template>
  <div class="dashboard-container">
    <!-- <div class="dashboard-text">name: {{ name }}</div> -->
    <!-- <div class="dashboard-text">欢迎【{{ name }}】使⽤CDN⼤数据分析系统</div> -->
    <div style="width:100%; height:80px; text-align:center; font-size:40px;">
      CDN⼤数据实时⽇志分析项⽬介绍
    </div>
    <div>
      <img src="@/assets/welcome/1.png" style="width:100%; height:700px;">
    </div>
    <div>
      <img src="@/assets/welcome/2.png" style="width:100%; height:400px;">
    </div>
    <div>
      <img src="@/assets/welcome/3.png" style="width:100%; height:563px;">
    </div>
    <div>
      <img src="@/assets/welcome/4.png" style="width:100%; height:436px;">
    </div>
    <div>
      <img src="@/assets/welcome/5.png" style="width:100%; height:246px;">
    </div>
    <div>
      <hr style="color:#97a8be;">
    </div>
    <div
      style="width:100%; text-align:center; font-weight:400; font-family:Helvetica
Neue, Helvetica, PingFang SC, Hiragino Sans GB, Microsoft YaHei, Arial, sans-serif; color:#97a8be; font-size:12px;"
    />
    <div>
      <hr style="color:#97a8be;">
    </div>
  </div>
</template>

<script>
import {
  mapGetters
} from 'vuex'
export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters(['name'])
  }
}
</script>

<style lang="scss" scoped>
  .dashboard {
    &-container {
      margin: 30px;
    }

    &-text {
      font-size: 30px;
      line-height: 46px;
    }
  }
</style>
