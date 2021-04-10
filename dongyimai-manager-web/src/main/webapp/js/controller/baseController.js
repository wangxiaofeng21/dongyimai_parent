app.controller('baseController',function ($scope) {

    //复选框
    $scope.selectIds = [];//选中id的集合
    //加工id集合
    $scope.updateSelection=function ($event, id) {
        //判断是否选中
        if ($event.target.checked){
            $scope.selectIds.push(id);
        }else{
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index,1);
        }
    }

    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();//初始化,页码变化
            //查询分页方法
            //$scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
        }
    };
})