
/**
     * 模块注册及配置代码
     *
     */
"use strict";
var app=angular.module("MyApp",[
        "ui.router",
        "oc.lazyLoad",
        'truncate',
        'LocalStorageModule'
    ]);
app.run(function($rootScope){
        $rootScope
            .$on('$stateChangeStart',
            function(event, toState, toParams, fromState, fromParams){
                $("#ui-view").html("");
                $(".page-loading").removeClass("hidden");
                /* $(".load_js").css("display","block");*/

            });
        $rootScope
            .$on('$stateChangeSuccess',
            function(event, toState, toParams, fromState, fromParams){
                $(".page-loading").addClass("hidden");
                /* $(".load_js").css("display","none");*/
            });
    });
app.config(function(localStorageServiceProvider){
        localStorageServiceProvider.setPrefix('demoPrefix');
    });
/*
     app.config(["$provide","$compileProvider","$controllerProvider","$filterProvider",
     function($provide,$compileProvider,$controllerProvider,$filterProvider){
     app.controller = $controllerProvider.register;
     app.directive = $compileProvider.directive;
     app.filter = $filterProvider.register;
     app.factory = $provide.factory;
     app.service  =$provide.service;
     app.constant = $provide.constant;
     }
     ]);*/







/**
 * 加载模块配置代码
 */
"use strict";
var pathL={
    build_css:'../build',     //gulp 编译之后的路径
   /* build_css:'..'              //原始路径*/
};
app.constant("Modules_Config",[
    {
        name:"home_Res",
        module:true,
        files:[
            /*"../content/bootstrap.min.css",
            "../scripts/layer/need/layer.css",*/
            ""+pathL.build_css+"/css/_layout-1ab85980de.css?V=0.99922",
            /*"../scripts/jquery.cookie.js",*/
            /*  "../scripts/layer/layer.js",*/
            "../js/helpTool.js?v=0.00012111"
        ]
    },
    {
        name:"illegaQuery_Res",
        module:true,
        files:[
            ""+pathL.build_css+"/css/illegaQuery-b28d8daecc.css",
            ""+pathL.build_css+"/css/LArea-525988661b.css",
            "../js/tool/LAreaData1.js",
            "../js/tool/LArea.js"
        ]
    },
    {
      name:"illegaDetail_Res",
        module:true,
        files:[
            ""+pathL.build_css+"/css/illegaDetail-b37d6c51d2.css"
        ]
    },
    {
        name:'illegaInfor_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/illegaInfor-d007b31b22.css"
        ]
    },
    {
        name:"carButler_Res",
        module:true,
        files:[
            "../scripts/swipe/css/swiper.min.css",
            ""+pathL.build_css+"/css/carButler-e3d0857a21.css?v=0.000001",
            {type:'js',path:"http://webapi.amap.com/maps?v=1.3&key=41f5a3e38b89fac5db6bd4a6961aeabd"},
            "../scripts/swipe/js/swiper.min.js",
            "../js/adapt/carButlerAdapt.js"
        ]
    },
    {
        name:"gasCard_Res",
        module:true,
        files:[
            ""+pathL.build_css+"/css/base-362f701c83.css",
            ""+pathL.build_css+"/css/gasCard-4c29d5abc2.css",
            "../js/tool/gasCard.js"
        ]
    },
    {
        name:"addCarType_Res",
        module:true,
        files:[
            ""+pathL.build_css+"/css/base-362f701c83.css",
            ""+pathL.build_css+"/css/addCarType-cb330ee91b.css"
        ]
    },
    {
        name:"login_Res",
        module:true,
        files:[
            ""+pathL.build_css+"/css/register-484382e5e7.css"
        ]
    },
    {
        name:"register_Res",
        module:true,
        files:[
            ""+pathL.build_css+"/css/register-484382e5e7.css"
        ]
    },
    {
        name:"cleanCar_Res",
        module:true,
        files:[
            ""+pathL.build_css+"/css/base-362f701c83.css",
            ""+pathL.build_css+"/css/cleanCar-fe6523161e.css"
        ]
    },
    {
        name:"orderRecord_Res",
        module:true,
        files:[
            ""+pathL.build_css+"/css/base-362f701c83.css",
            ""+pathL.build_css+"/css/orderRecord-3fdd1a84f9.css"
        ]
    },
    {
        name:"rentCar_Res",
        module:true,
        files:[
            ""+pathL.build_css+"/css/base-362f701c83.css",
            ""+pathL.build_css+"/css/rentCar-14d38f5bbf.css"
        ]
    },
    {
        name:"replaceStop_Res",
        module:true,
        files:[
            "../content/mobiscroll-2.13.2.full.min.css",
            ""+pathL.build_css+"/css/replaceStop-c7958495b7.css?V=0.0005",
            {type:'js',path:"http://webapi.amap.com/maps?v=1.3&key=41f5a3e38b89fac5db6bd4a6961aeabd"},
            "../scripts/mobiscroll-2.13.2.full.min.js"
        ]
    },
    {
        name:"replaceOrder_Res",
        module:true,
        files:[
            ""+pathL.build_css+"/css/base-362f701c83.css?V=1.0.7",
            "../scripts/swipe/css/swiper.min.css",
            ""+pathL.build_css+"/css/replaceOrder-60a09df684.css?V=1.0.7",
            "http://res.wx.qq.com/open/js/jweixin-1.0.0.js",
            "../js/tool/pic.js",
            "../scripts/swipe/js/swiper.min.js"
        ]
    },
    {
        name:'orderAssess_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/base-362f701c83.css",
            ""+pathL.build_css+"/css/orderAssess-acb71548a0.css"
        ]
    },
    {
        name:'chart_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/chart-e7a7259c7d.css",
            "../js/tool/highcharts.js",
           /* "../scripts/iscroll.js"*/
            /*"../scripts/iscroll-probe.js"*/
        ]
    },
    {
        name:'proChart_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/proChart-7116bc323a.css",
            "../js/tool/highcharts.js",
            "../scripts/iscroll.js"
        ]
    },
    {
        name:'report_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/report-e0a7b82185.css",
            '../js/tool/highcharts.js'
        ]
    },
    {
        name:'actOne_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/actOne-77e4b3d7be.css",
            /*"http://res.wx.qq.com/open/js/jweixin-1.0.0.js",*/
            "../js/adapt/actOneAdapt.js"
        ]
    },
    {
        name:'actTwo_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/actTwo-6d6fc4a061.css",
        ]

    },
    {
        name:'actFive_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/actFive-730fefe858.css",
        ]
    },
    {
        name:'actSix_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/actSix-b93d66cb42.css",
        ]

    },
    {
        name:'actThree_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/actThree-957cef68ca.css",
        ]
    },
    {
        name:'actFour_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/actFour-92fc00be27.css",
        ]
    },
    {
        name:'actSeven_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/actSeven-16dde92fa5.css",
        ]
    },
    {
        name:'actEight_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/actEight-5c0e916b66.css",
        ]

    },
    {
        name:'invit_Res',
        module:true,
        files:[
            "../content/mobiscroll-2.13.2.full.min.css",
            ""+pathL.build_css+"/css/invit-504ab07b39.css",
            "../scripts/mobiscroll-2.13.2.full.min.js"
        ]
    },
    {
        name:'invitCred_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/invitCred-cf28ea7576.css",
        ]
    },
    {
        name:'parkPay_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/parkPay-d383bd5768.css",
            ""+pathL.build_css+"/css/jianPan-03048f7cc2.css",
            "http://res.wx.qq.com/open/js/jweixin-1.0.0.js",
        ]
    },
    {
        name:'paySuccess_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/paySuccess-21e90c8101.css",
        ]
    },
    {
        name:'payOrder_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/payOrder-58e62e1eaa.css",
        ]
    },
    {
        name:'payAgree_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/payAgree-493cac413a.css"

        ]
    },
    {
        name:'reservedPark_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/reservedPark-7aa2a9403b.css",
            {type:'js',path:"http://webapi.amap.com/maps?v=1.3&key=41f5a3e38b89fac5db6bd4a6961aeabd"},
            "../scripts/iscroll.js",
           "../js/adapt/reservedParkAdapt.js"
        ]
    },
    {
        name:'reservedParkOrder_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/reservedParkOrder-b24361ae8b.css",
            "../scripts/iscroll.js",
            "../js/adapt/reservedParkAdapt.js",
            "http://res.wx.qq.com/open/js/jweixin-1.0.0.js",
        ]
    },
    {
        name:'reservedOrder_Res',
        module:true,
        files:[
            ""+pathL.build_css+"/css/payOrder-58e62e1eaa.css",
            "../scripts/jquery.qrcode.min.js",
            "../scripts/jquery-barcode.js"
        ]
    },
    {
        name:'scanPark_Res',
        module:true,
        files:[
            "../content/mobiscroll-2.13.2.full.min.css",
            ""+pathL.build_css+"/css/replaceStop-c7958495b7.css?V=0.0005",
            /* {type:'js',path:"http://webapi.amap.com/maps?v=1.3&key=41f5a3e38b89fac5db6bd4a6961aeabd"},*/
            "../scripts/mobiscroll-2.13.2.full.min.js"
        ]
    },
    {
        name:'payNumber_Res',
        module:true,
        files:[
               ""+pathL.build_css+"/css/payNumber-e98f6a6cf4.css",
               /*"../js/adapt/reservedParkAdapt.js",*/
       ]
    }
]);
app.config(["$ocLazyLoadProvider","Modules_Config",routeFnLoad]);
function routeFnLoad($ocLazyLoadProvider,Modules_Config){
    $ocLazyLoadProvider.config({
        debug:false,
        events:false,
        modules:Modules_Config
    })
};



/**
 * 路由配置及加载代码
 */
"use strict";
var path={
    build:'../build/javascript',   //gulp 编译之后的路径
   /* build:'../js'                  //原始路径*/

};
app.config(["$stateProvider","$urlRouterProvider",routeFn]);
function routeFn($stateProvider,$urlRouterProvider){
    $urlRouterProvider.when('','/home');
    $stateProvider
        .state('home',{
            url:'/home',
            templateUrl:'index.html',
            controller:'Maintrl',
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("home_Res").then(
                        function(){
                            return $ocLazyLoad.load(""+path.build+"/controllers/indexController-68cea1df1f.js");
                        }
                    )
                }]
            }
        })
        //车管家
        .state('home.carButler',{
            url:'/carButler',
            views:{
                'homeCont':{
                    templateUrl:"../templates/carButler.html",
                    controller:'carButlerCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("carButler_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/carButlerController-5f1c8f03b7.js',
                                ''+path.build+'/services/carButlerService-e76f52bc9e.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //违章查询
        .state('home.illegalQuery',{
            url:'/illegaQuery',
            views:{
                'homeCont':{
                    templateUrl:'../templates/illegaQuery.html',
                    controller:'illegaQueryCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("illegaQuery_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/illegaQueryController-1ccf166d33.js',
                                ''+path.build+'/services/illegaQueryService-a1d1435c7c.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //违章列表页面
        .state('home.illegaDetail',{
            url:'/illegaDetail',
            views:{
                'homeCont':{
                    templateUrl:'../templates/illegaDetail.html',
                    controller:'illegaDetailCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("illegaDetail_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/illegaDetailController-784e98b5d0.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //违章详情页面
        .state('home.illegaInfor',{
            url:'/illegaInfor/:date/:area/:act/:code/:fen/:money/:handled',
            views:{
                'homeCont':{
                    templateUrl:'../templates/illegaInfor.html',
                    controller:'illegaInforCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("illegaInfor_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/illegaInforController-515de7c0d0.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //添加加油卡充值
        .state('home.gasCard',{
            url:'/gasCard',
            views:{
                'homeCont':{
                    templateUrl:'../templates/gasCard.html',
                    controller:'gasCardCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("gasCard_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/gasCardController-393bda19c1.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //添加加油卡类型
        .state('home.addCarType',{
            url:'/addCarType',
            views:{
                'homeCont':{
                    templateUrl:'../templates/addCarType.html',
                    controller:'addCarTypeCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("addCarType_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/addCarTypeController-89cb45da21.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //登录
       /* .state('home.login',{
            url:'/login',
            views:{
                'homeCont':{
                    templateUrl:'../templates/login.html',
                    controller:'loginCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("login_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/loginController-1b170ef408.js',
                                ''+path.build+'/services/loginService-9fb132be14.js'
                            ]);
                        }
                    )
                }]
            }
        })*/
        //免密登录 -验证码登录
        .state('home.login',{
            url:'/login',
            views:{
                'homeCont':{
                    templateUrl:'../templates/login.html',
                    controller:'loginFreeCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("login_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/loginController-1b170ef408.js',
                                ''+path.build+'/services/loginService-9fb132be14.js',
                                ''+path.build+'/services/registerService-909181878f.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //注册
        .state('home.register',{
            url:'/register',
            views:{
                'homeCont':{
                    templateUrl:'../templates/register.html',
                    controller:'registerCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("register_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/registerController-6166759d3a.js',
                                ''+path.build+'/services/registerService-909181878f.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //洗车
        .state('home.cleanCar',{
            url:'/cleanCar',
            views:{
                'homeCont':{
                    templateUrl:'../templates/cleanCar.html',
                    controller:'cleanCarCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("cleanCar_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/cleanCarController-b94fe66062.js',
                                ''+path.build+'/services/cleanCarService-7941b81b12.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //洗车订单记录
        .state('home.orderRecord',{
            url:'/orderRecord',
            views:{
                'homeCont':{
                    templateUrl:'../templates/orderRecord.html',
                    controller:'orderRecordCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("orderRecord_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/orderRecordController-43edef6c38.js',
                                ''+path.build+'/services/orderRecordService-4ce0f39460.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //租车
        .state('home.rentCar',{
            url:'/rentCar',
            views:{
                'homeCont':{
                    templateUrl:'../templates/rentCar.html',
                    controller:'rentCarCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("rentCar_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/rentCarController-0c5efeccf5.js',
                                ''+path.build+'/services/rentCarService-281beac267.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //代泊
        .state('home.replaceStop',{
            url:'/replaceStop',
            views:{
                'homeCont':{
                    templateUrl:'../templates/replaceStop-20160815.html',
                    controller: 'replaceStopCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("replaceStop_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/replaceStopController-ac6e9f5e92.js',
                                ''+path.build+'/services/replaceStopService-0b7626519b.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //代泊订单
        .state('home.replaceOrder',{
            url:'/replaceOrder',
            views:{
                'homeCont':{
                    templateUrl:'../templates/replaceOrder.html',
                    controller:'replaceOrderCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("replaceOrder_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/replaceOrderController-986f94234f.js?V=1.0.7',
                                ''+path.build+'/services/replaceOrderService-d22b5e35af.js?V=1.0.7'
                            ]);
                        }
                    )
                }]
            }
        })
        //代泊订单评价
        .state('home.orderAssess',{
            url:'/orderAssess',
            views:{
                'homeCont':{
                    templateUrl:'../templates/orderAssess.html',
                    controller:'orderAssessCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("orderAssess_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/orderAssessController-938e6feb33.js',
                                ''+path.build+'/services/orderAssessService-8369db67f2.js'
                            ]);
                        }
                    )
                }]
            }
        })
        //首页报表——移动端
        .state('home.chart',{
            url:'/chart',
            views:{
                'homeCont':{
                    templateUrl:'../templates/chart.html',
                    controller:'chartCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("chart_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/chartController-d7ffd5ffbc.js?V=1.0.1',
                                ''+path.build+'/services/chartService-0cf9e6617f.js'
                            ])
                        }
                    )
                }]
            }
        })
        //项目统计--移动端
        .state('home.proChart',{
            url:'/proChart',
            views:{
                'homeCont':{
                    templateUrl:'../templates/proChart.html',
                    controller:'proChartCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("proChart_Res").then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/proChartController-4e39974ec1.js?V=1.0.7',
                                ''+path.build+'/services/proChartService-663ddd56dc.js?V=1.0.7'
                            ])
                        }
                    )
                }]
            }
        })
        //报表--PC端
        .state('home.report',{
            url:'/report',
            views:{
                'homeCont':{
                    templateUrl:'../templates/report.html',
                    controller:'reportCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("report_Res").then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/reportController-b47a23bb48.js?V=1.0.1',
                                ''+path.build+'/services/chartService-0cf9e6617f.js'
                            ])
                        }
                    )
                }]
            }
        })
        //活动 --1
        .state('home.actOne',{
            url:'/actOne',
            views:{
                'homeCont':{
                    templateUrl:'../templates/actOne.html',
                    controller:'actOneCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("actOne_Res").then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/actOneController-44cf5d33a6.js',
                                ''+path.build+'/services/activeService-bc1baeb739.js'
                            ])
                        }
                    )
                    /*return $ocLazyLoad.load([
                        ''+path.build+'/controllers/actOneController-44cf5d33a6.js'
                    ])*/
                }]
            }
        })
        //活动 --2
        .state('home.actTwo',{
            url:'/actTwo',
            views:{
                'homeCont':{
                    templateUrl:'../templates/actTwo.html',
                    controller:'actTwoCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("actTwo_Res").then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/actTwoController-4bd2350a85.js',
                            ])
                        }
                    )
                }]
            }
        })
        //活动 --5
        .state('home.actFive',{
            url:'/actFive',
            views:{
                'homeCont':{
                    templateUrl:'../templates/actFive.html',
                    controller:'actFiveCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("actFive_Res").then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/actFiveController-23dbbeaad7.js',
                            ])
                        }
                    )
                }]
            }
        })
        //活动 --3
        .state('home.actThree',{
            url:'/actThree',
            views:{
                'homeCont':{
                    templateUrl:'../templates/actThree.html',
                    controller:'actThreeCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("actThree_Res").then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/actThreeController-d844f9d92c.js',
                            ])
                        }
                    )
                }]
            }
        })
        //活动 --4
        .state('home.actFour',{
            url:'/actFour',
            views:{
                'homeCont':{
                    templateUrl:'../templates/actFour.html',
                    controller:'actFourCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("actFour_Res").then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/actFourController-9029efe3b0.js',
                            ])
                        }
                    )
                }]
            }
        })
        //活动 --7
        .state('home.actSeven',{
            url:'/actSeven',
            views:{
                'homeCont':{
                    templateUrl:'../templates/actSeven.html',
                    controller:'actSevenCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("actSeven_Res").then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/actSevenController-1c7f7d93cf.js',
                            ])
                        }
                    )
                }]
            }
        })
        //活动 --8
        .state('home.actEight',{
            url:'/actEight',
            views:{
                'homeCont':{
                    templateUrl:'../templates/actEight.html',
                    controller:'actEightCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("actEight_Res").then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/actEightController-9592f70118.js',
                            ])
                        }
                    )
                }]
            }
        })
        //活动 --6
        .state('home.actSix',{
            url:'/actSix',
            views:{
                'homeCont':{
                    templateUrl:'../templates/actSix.html',
                    controller:'actSixCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("actSix_Res").then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/actSixController-99522812ad.js',
                            ])
                        }
                    )
                }]
            }
        })
        //测试清楚缓存页面
        .state('home.test',{
            url:'/test',
            views:{
                'homeCont':{
                    templateUrl:'../templates/test.html',
                    controller:'testCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load([
                        ''+path.build+'/controllers/testController-c96c0475ff.js',
                    ])
                }]
            }

        })


        //访客受邀
        .state('home.invit',{
            url:'/invit',
            views:{
                'homeCont':{
                    templateUrl:'../templates/invit.html',
                    controller:'invitCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load('invit_Res').then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/invitController-3f8110a4ec.js',
                                ''+path.build+'/services/invitService-f82cd7a06e.js',
                            ])
                        }
                    )
                }]
            }
        })
        //访客凭证
        .state('home.invitCred',{
            url:'/invitCred',
            views:{
                'homeCont':{
                    templateUrl:'../templates/invitCred.html',
                    controller:'invitCredCtrl'
                }
            },
            resolve:{
                deps:['$ocLazyLoad',function($ocLazyLoad){
                    return $ocLazyLoad.load('invitCred_Res').then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/invitCredController-b6797c466e.js',
                                ''+path.build+'/services/invitCredService-e5698fd0ec.js',
                            ])
                        }
                    )
                }]
            }
        })

        //停车缴费
        .state('home.parkPay',{
            url:'/parkPay',
            views:{
                'homeCont':{
                    templateUrl:'../templates/parkPay.html',
                    controller:'parkPayCtrl'
                }
            },
            resolve:{
                deps:['$ocLazyLoad',function($ocLazyLoad){
                    return $ocLazyLoad.load('parkPay_Res').then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/parkPayController-e1ab99920d.js',
                                ''+path.build+'/services/parkPayService-d30a2fa801.js',
                            ])
                        }
                    )
                }]
            }
        })

        //支付成功
        .state('home.paySuccess',{
            url:'/paySuccess',
            views:{
                'homeCont':{
                    templateUrl:'../templates/paySuccess.html',
                    controller:'paySuccessCtrl'
                }
            },
            resolve:{
                deps:['$ocLazyLoad',function($ocLazyLoad){
                    return $ocLazyLoad.load('paySuccess_Res').then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/paySuccessController-a125caa794.js',
                                ''+path.build+'/services/paySuccessService-96f9fc7b89.js',
                            ])
                        }
                    )
                }]
            }
        })
        //支付凭证
        .state('home.payOrder',{
            url:'/payOrder',
            views:{
                'homeCont':{
                    templateUrl:'../templates/payOrder.html',
                    controller:'payOrderCtrl'
                }
            },
            resolve:{
                deps:['$ocLazyLoad',function($ocLazyLoad){
                    return $ocLazyLoad.load('payOrder_Res').then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/payOrderController-fcbf2a6450.js',
                                ''+path.build+'/services/paySuccessService-96f9fc7b89.js',
                            ])
                        }
                    )
                }]
            }
        })
        //支付协议
        .state('home.payAgree',{
            url:'/payAgree',
            views:{
                'homeCont':{
                    templateUrl:'../templates/payAgree.html',
                    controller:'payAgreeCtrl'
                }
            },
            resolve:{
                deps:['$ocLazyLoad',function($ocLazyLoad){
                    return $ocLazyLoad.load('payAgree_Res').then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/payAgreeController-2b35443879.js',
                            ])
                        }
                    )
                }]
            }
        })
        //用户协议
        .state('home.useAgree',{
            url:'/useAgree',
            views:{
                'homeCont':{
                    templateUrl:'../templates/useAgree.html',
                    controller:'useAgreeCtrl'
                }
            },
            resolve:{
                deps:['$ocLazyLoad',function($ocLazyLoad){
                    return $ocLazyLoad.load([
                        ''+path.build+'/controllers/useAgreeController-9192b5053e.js',
                    ])
                }]
            }
        })

        //预约停车 列表
        .state('home.reservedPark',{
            url:'/reservedPark',
            views:{
                'homeCont':{
                    templateUrl:'../templates/reservedPark.html',
                    controller:'reservedParkCtrl'
                }
            },
            resolve:{
                deps:['$ocLazyLoad',function($ocLazyLoad){
                    return $ocLazyLoad.load('reservedPark_Res').then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/reservedParkController-f90841b713.js',
                                ''+path.build+'/services/reservedParkService-8f58cc7728.js'
                            ])
                        }
                    )
                }]
            }
        })

        //预约停车 下单页
        .state('home.reservedParkOrder',{
            url:'/reservedParkOrder',
            views:{
                'homeCont':{
                    templateUrl:'../templates/reservedParkOrder.html',
                    controller:'reservedParkOrderCtrl'
                }
            },
            resolve:{
                deps:['$ocLazyLoad',function($ocLazyLoad){
                    return $ocLazyLoad.load('reservedParkOrder_Res').then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/reservedParkOrderController-7be2a9b680.js',
                                ''+path.build+'/services/reservedParkOrderService-70c2f8712f.js'
                            ])
                        }
                    )
                }]
            }
        })

        //预约停车 凭证
        .state('home.reservedOrder',{
            url:'/reservedOrder',
            views:{
                'homeCont':{
                    templateUrl:'../templates/reservedOrder.html',
                    controller:'reservedPayOrderCtrl'
                }
            },
            resolve:{
                deps:['$ocLazyLoad',function($ocLazyLoad){
                    return $ocLazyLoad.load('reservedOrder_Res').then(
                        function(){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/reservedOrderController-7da8b394bb.js',
                                ''+path.build+'/services/paySuccessService-96f9fc7b89.js',
                            ])
                        }
                    )
                }]
            }
        })

        //微信扫码代泊 ---代泊员端
        .state('home.scanPark',{
            url:'/scanPark',
            views:{
                'homeCont':{
                    templateUrl:'../templates/scanPark.html',
                    controller:'scanParkCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load("scanPark_Res").then(
                        function (){
                            return $ocLazyLoad.load([
                                ''+path.build+'/controllers/scanParkController-0601f12a2f.js',
                                ''+path.build+'/services/scanParkService-f2bb9fb8dc.js'
                            ]);
                        }
                    )
                }]
            }
        })

        //活动结束页
        .state('home.actOver',{
            url:'/actOver',
            views:{
                'homeCont':{
                    templateUrl:'../templates/actOver.html',
                    controller:'actOverCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                    return $ocLazyLoad.load([
                        ''+path.build+'/controllers/actOverController-cbab00b1c9.js'
                    ])
                }]
            }

        })
        
         //关注公众号页面
        .state('home.payNumber',{
            url:'/payNumber',
            views:{
                'homeCont':{
                    templateUrl:'../templates/payNumber.html',
                    controller:'payNumberCtrl'
                }
            },
            resolve:{
                deps:["$ocLazyLoad",function($ocLazyLoad){
                	return $ocLazyLoad.load("payNumber_Res").then(
                            function (){
                                return $ocLazyLoad.load([
                                        ''+path.build+'/controllers/payNumberController-34e3b3f33c.js'
                                ]);
                            }
                        )
                  
                }]
            }

        })


}

