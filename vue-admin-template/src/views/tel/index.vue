<template>
  <div class="app-container">
    <el-form ref="form" :model="form" :rules="dateRules" label-width="120px">
      <el-form-item label="输入⼿机号" prop="tn">
        <el-input ref="tn" v-model="form.tn" name="tn" style="width:91%" />
      </el-form-item>
      <el-form-item label="选择时间">
        <el-col :span="11">
          <el-form-item prop="date1">
            <el-date-picker
              ref="date1"
              v-model="form.date1"
              name="date1"
              type="date"
              :editable="false"
              placeholder="开始"
              style="width: 80%;"
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
              type="date"
              :editable="false"
              placeholder="结束(可选)"
              style="width:80%;"
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
    <el-table v-loading="listLoading" :data="list" element-loading-text="Loading" border fit highlight-current-row>
      <el-table-column width="140" align="center" label="⼿机号" prop="phones:phone" :formatter="fone" />
      <el-table-column label="产品名" align="center" prop="pids:pname" />
      <el-table-column label="客户" width="200" align="center" prop="spids:spname" />
      <el-table-column label="流量（兆）" width="140" align="center" prop="traffics:traffic" />
      <el-table-column label="访问时间" width="200" align="center" prop="times:time" :formatter="ftwo" />
      <el-table-column align="center" label="省份城市" width="200" prop="phones:province" :formatter="fthree" />
    </el-table>
  </div>
</template>
<script>
import {
  getXxx
} from '@/api/tel'
export default {
  filters: {
    statusFilter(status) {}
  },
  data() {
    const validateTn = (rule, value, callback) => {
      if (!value) {
        callback(new Error('请输入⼿机号'))
      } else if (!/^1[3456789]\d{9}$/.test(value)) {
        callback(new Error('⼿机号格式不正确'))
      } else {
        callback()
      }
    }
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
        tn: [{
          required: true,
          trigger: 'blur',
          validator: validateTn
        }],
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
        tn: '',
        date1: '',
        date2: ''
      },
      // 表格相关内容
      list: null,
      listLoading: false
    }
  },
  methods: {
    fone(row, column, cellValue, index) {
      const msg = row[column.property]
      if (msg === undefined) {
        return ''
      }
      return msg.indexOf('-') > 0 ? msg.substring(0, msg.indexOf('-')) : msg
    },
    ftwo(row, column, cellValue, index) {
      const msg = row[column.property]
      if (msg === undefined) {
        return ''
      }
      console.log(msg)
      const y = msg.substr(0, 4)
      const m = msg.substr(4, 2)
      const d = msg.substr(6, 2)
      const h = msg.substr(8, 2)
      return y + '年' + m + '⽉' + d + '⽇' + h + '时'
    },
    fthree(row, column, cellValue, index) {
      const msg = row[column.property]
      if (msg === undefined) {
        return ''
      }
      return msg.indexOf('-') > 0 ? msg.substring(0, msg.indexOf('-')) : msg
    },
    onSubmit() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          this.$message('已提交')
          var b = this.form.date1
          var e = this.form.date2
          var tn = this.form.tn
          this.listLoading = true // 表格数据加载中
          getXxx(b, e, tn)
            .then((response) => {
              console.log(response.data)
              this.list = response.data
              // console.log(response.data.items)
              // this.list = response.data.items
              this.listLoading = false
            })
            .catch(function(error) {
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
