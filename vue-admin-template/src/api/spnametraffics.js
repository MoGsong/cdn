import request from '@/utils/request'
export function getXxx(b, e) {
  return request({
    url: '/api/tspnametraffics?b=' + b + '&e=' + e,
    method: 'get'
  })
}
