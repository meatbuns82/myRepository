import axios from 'axios'

const BASEURL = '/feezet-boot'
const service = axios.create({
    baseURL:BASEURL,
    timeout:2000,
})


export default service