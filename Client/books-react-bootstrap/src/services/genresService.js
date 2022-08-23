import http from './httpService'
import * as apiUrl from '../config.json'

export function getGenres() {
  return http.get(apiUrl + '/genres')
}
