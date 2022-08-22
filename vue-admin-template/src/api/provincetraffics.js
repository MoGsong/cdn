import request from '@/utils/request'
export function getXxx(b, e) {
  return request({
    url: '/api/tprovincetraffics?b=' + b + '&e=' + e,
    method: 'get'
  })
}
