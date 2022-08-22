import { validUsername } from '@/utils/validate';

export default (await import('vue')).defineComponent({
name: 'Login',
data() {
const validateUsername = (rule, value, callback) => {
if (!validUsername(value)) {
callback(new Error('请输入正确的⽤户名'));
} else {
callback();
}
};
const validatePassword = (rule, value, callback) => {
if (value.length < 6) {
callback(new Error('密码⻓度⾄少6位'));
} else {
callback();
}
};
return {
loginForm: {
username: 'zyj',
password: '123456'
},
loginRules: {
username: [{
required: true,
trigger: 'blur',
validator: validateUsername
}],
password: [{
required: true,
trigger: 'blur',
validator: validatePassword
}]
},
loading: false,
passwordType: 'password',
redirect: undefined
};
},
watch: {
$route: {
handler: function (route) {
this.redirect = route.query && route.query.redirect;
},
immediate: true
}
},
methods: {
showPwd() {
if (this.passwordType === 'password') {
this.passwordType = '';
} else {
this.passwordType = 'password';
}
this.$nextTick(() => {
this.$refs.password.focus();
});
},
handleLogin() {
this.$refs.loginForm.validate((valid) => {
if (valid) {
this.loading = true;
this.$store.dispatch('user/login', this.loginForm).then(() => {
this.$router.push({
path: this.redirect || '/'
});
this.loading = false;
}).catch(() => {
this.loading = false;
});
} else {
console.log('error submit!!');
return false;
}
});
}
}
});
const __VLS_template = () => ({});
