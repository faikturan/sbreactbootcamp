import http from './httpService'

export function getGenres() {
  return http.get('http://localhost:8088/api' + '/genres')
}
