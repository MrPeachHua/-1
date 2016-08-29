/**
 * Created with JetBrains WebStorm
 * User: antBrother
 * Date:2016/8/8
 */
'use strict';
var myService=angular.module('scanParkServices',[]);
myService.factory('scanParkService',['$http',function($http){
    return{
        //�ɴ�������
        getCanParkList:function(lng,lat){
            return $http.get('/wx_share/ReplaceStop/canParkList?lng='+lng+"&lat="+lat+"&version="+'1.3.6');
        },
        //���� Ԥ��ȡ��
        getTakeTimePrice:function(parkingId,startTime,endTime,version){
            return $http.post('/wx_share/ReplaceStop/calcParkPrice?parkingId='+parkingId+'&startTime='+startTime+'&endTime='+endTime+'&version='+version)
        },
        /**
         * �������� ������������
         * @param customerId      �û�Id
         * @param carNumber       ���ƺ�
         * @param parkingId       ����Id
         * @param startTime       ��ʼʱ��
         * @param endTime         ȡ��ʱ��
         * @param isContinue      �Ƿ����  ��ʼΪ0,����Ϊ1
         * @returns {HttpPromise}
         */
        getOrderC:function(customerId,carNumber,parkingId,startTime,endTime,isContinue){
            return $http.get('/wx_share/ReplaceStop/orderc?customerId='+customerId+"&carNumber="+carNumber+"&orderType="+'12'+"&parkingId="+parkingId+"&startTime="+startTime+"&endTime="+endTime+"&isContinue="+isContinue+"&version="+'1.3.7');
        }
    }
}]);
