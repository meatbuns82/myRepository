import axios from '../utils/request'

export function login(datas){
    return axios({
        method: 'POST',
        url: '/login/hello',
        data: datas
    })
}