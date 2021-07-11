import request from '@/utils/request'

// 查询就诊记录列表
export function listMethod(query) {
  return request({
    url: '/system/method/list',
    method: 'get',
    params: query
  })
}

// 查询就诊记录详细
export function getMethod(methodId) {
  return request({
    url: '/system/method/' + methodId,
    method: 'get'
  })
}

// 新增就诊记录
export function addMethod(data) {
  return request({
    url: '/system/method',
    method: 'post',
    data: data
  })
}

// 修改就诊记录
export function updateMethod(data) {
  return request({
    url: '/system/method',
    method: 'put',
    data: data
  })
}

// 删除就诊记录
export function delMethod(methodId) {
  return request({
    url: '/system/method/' + methodId,
    method: 'delete'
  })
}

// 导出就诊记录
export function exportMethod(query) {
  return request({
    url: '/system/method/export',
    method: 'get',
    params: query
  })
}