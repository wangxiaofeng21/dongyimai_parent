app.controller('brandController' ,function($scope,$http,$controller,brandService){

    //继承base的域
    $controller('baseController',{$scope:$scope});

    //读取列表数据绑定到表单中
    $scope.findAll=function(){
        brandService.findAll().success(
            function(response){
                $scope.list=response;
            }
        );
    }

    //重新加载
    $scope.reloadList=function(){
        //切换页码
        $scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    $scope.save=function(){
        //新增,修改,区别在于id
        if ($scope.entity.id == null){
            //新增
            brandService.add($scope.entity).success(
                function(response){
                    if (response.success){
                        $scope.reloadList();//重新加载
                    }else{
                        alert(response.message);
                    }
                }
            );
        }else{
            //修改
            brandService.update($scope.entity).success(
                function(response){
                    if (response.success){
                        $scope.reloadList();//重新加载
                        //window.location.href = "/admin/brand.html"
                    }else{
                        alert(response.message);
                    }
                }
            );
        }

    }

    //回显
    $scope.findOne=function(id){
        brandService.findOne(id).success(
            function(response){
                $scope.entity=response;//响应一个对象
            }
        );
    }

    //分页
    $scope.findPage=function (page,rows) {
        //发请求,得响应
        $http.get('../brand/findPage.do?page='+page+"&rows="+rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        )
    }

    //删除
    $scope.dele=function(){
        brandService.dele($scope.selectIds).success(
            function(response){
                if (response.success){
                    $scope.reloadList();
                }else{
                    alert(response.message);
                }
            }
        );
    }

    //模糊查询
    $scope.searchEntity={};//定义搜索对象
    $scope.search=function(page,rows){
        brandService.search(page, rows ,$scope.searchEntity).success(
            function(response){
                $scope.paginationConf.totalItems=response.total;//总记录数
                $scope.list=response.rows;//给列表变量赋值
            }
        );
    }
});