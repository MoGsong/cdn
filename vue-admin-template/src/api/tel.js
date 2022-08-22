import request from '@/utils/request'
export function getXxx(b, e, tn) {
  return request({
    url: '/api/tel?b=' + b + '&e=' + e + '&tn=' + tn,
    method: 'get'
  })
}
