//这个文件的配置 可以简化 webpack的打包命令，在这里配置 要打包的文件和打包成的目标文件路径和文件名
const path = require ('path')
const VueLoaderPlugin = require('vue-loader/lib/plugin')

module.exports={
    entry:path.join(__dirname,'./src/main.js'), //使用webpack要打包的那个文件
    output:{
        path:path.join(__dirname,'./dist'),//webpack打包成哪个文件

        filename:'bundle.js'
    },
    mode:'development',
    module:{
        rules:[
            {test:/\.css$/,use:['style-loader','css-loader']},
            {test:/\.vue$/,use:'vue-loader'},
            {test:/\.svg|jpg|gif|png$/,use:'url-loader'}
        ]
    },
    plugins:[
        new VueLoaderPlugin()
    ],
    devServer: {
        proxy:{
            '/feezet-boot':{
                target:'http://localhost:8081',
                changeOrigin:true,
                pathRewrite:{
                    '^/feezet-boot':''
                }
            }
        }
    }
}