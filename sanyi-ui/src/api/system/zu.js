import request from '@/utils/request'

// 查询魅族列表
export function listZu(query) {
  return request({
    url: '/system/zu/list',
    method: 'get',
    params: query
  })
}

// 查询魅族详细
export function getZu(id) {
  return request({
    url: '/system/zu/' + id,
    method: 'get'
  })
}

// 新增魅族
export function addZu(data) {
  return request({
    url: '/system/zu',
    method: 'post',
    data: data
  })
}

// 修改魅族
export function updateZu(data) {
  return request({
    url: '/system/zu',
    method: 'put',
    data: data
  })
}

// 删除魅族
export function delZu(id) {
  return request({
    url: '/system/zu/' + id,
    method: 'delete'
  })
}

// 导出魅族
export function exportZu(query) {
  return request({
    url: '/system/zu/export',
    method: 'get',
    params: query
  })
}