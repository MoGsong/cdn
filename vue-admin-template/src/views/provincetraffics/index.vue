<template>
  <div class="app-container">
    <el-form ref="form" :model="form" :rules="dateRules" label-width="120px">
      <el-form-item label="选择时间">
        <el-col :span="11">
          <el-form-item prop="date1">
            <el-date-picker
              ref="date1"
              v-model="form.date1"
              name="date1"
              :editable="false"
              type="date"
              placeholder="开始"
              style="width: 100%;"
              value-format="yyyyMMdd"
            />
          </el-form-item>
        </el-col>
        <el-col :span="2" class="line">-</el-col>
        <el-col :span="11">
          <el-form-item prop="date2">
            <el-date-picker
              ref="date2"
              v-model="form.date2"
              name="date2"
              :editable="false"
              type="date"
              placeholder="结束(可选)"
              style="width:100%;"
              value-format="yyyyMMdd"
            />
          </el-form-item>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click.native.prevent="onSubmit">查询</el-button>
        <el-button @click="onCancel">取消</el-button>
      </el-form-item>
    </el-form>
    <ve-histogram :data="chartData" :extend="vchartsConfig.extend" />
  </div>
</template>
<script>
import VeHistogram from 'v-charts/lib/histogram'
import {
  getXxx
} from '@/api/provincetraffics'
export default {
  components: {
    VeHistogram
  },
  data() {
    const validateDate1 = (rule, value, callback) => {
      if (!value) {
        callback(new Error('请选择开始时间'))
      } else {
        callback()
      }
    }
    const validateDate2 = (rule, value, callback) => {
      if (this.form.date1 && value) {
        if (this.form.date1 > value) {
          callback(new Error('结束时间不能⼩于开始时间，请重新选择'))
        } else {
          callback()
        }
      } else {
        callback()
      }
    }
    return {
      // 表单验证
      dateRules: {
        date1: [{
          required: true,
          trigger: 'blur',
          validator: validateDate1
        }],
        date2: [{
          validator: validateDate2
        }]
      },
      // 表单相关内容
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      // v-charts相关内容
      chartData: {
        columns: ['province', '流量值(单位：兆)'],
        rows: []
      },
      vchartsConfig: {
        extend: {
          // 柱形区域
          grid: {
            show: true,
            backgroundColor: '#FFF6F3'
          },
          // 柱⼦
          series(v) {
            v.forEach((i) => {
              i.barWidth = 10
              i.barGap = 1
              // 柱条最⼩⾼度，可⽤于防⽌某数据项的值过⼩⽽影响交互
              i.barMinHeight = 2
              i.itemStyle = {}
              i.label = {}
            })
            return v
          },
          // x轴的样式
          xAxis: {
            axisLabel: {
              margin: 5,
              interval: 0,
              rotate: 30
            }
          },
          yAxis: {
            axisLabel: {}
          }
        }
      }
    }
  },
  mounted() {
    console.log('xxx')
  },
  methods: {
    onSubmit() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          this.$message('已提交!')
          var b = this.form.date1
          var e = this.form.date2
          getXxx(b, e).then((response) => {
            this.chartData.rows = []
            var dataShow = response.data // 清空上次显⽰的数据，避免数据合并
            for (var i = 0; i < dataShow.length; i++) {
              this.chartData.rows.push({
                province: dataShow[i].province,
                '流量值(单位：兆)': dataShow[i].traffics
              })
            }
          }).catch(function(error) {
            console.log(error)
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    onCancel() {
      this.$message({
        message: '已取消',
        type: 'warning'
      })
    }
  }
}
</script>
<style scoped>
    .line {
        text-align: center;
    }
</style>
