
app.controller("category-ctrl", function($scope,$routeParams,$location,$http){
  
  $scope.items = [];
  $scope.form = {};
  
  
  
  $scope.delete = function(cate){
    
    $http.delete(`/rest/admin/categories/${cate.id}`).then(res =>{
      var index = $scope.items.findIndex(p => p.id == cate.id);
      $scope.items.splice(index,1);
      alert("Xóa thành công");
    }).catch(error => {
      alert("Xóa thất bại");
    })
    
  }
  
  $scope.initialize = function(){
    $http.get("/rest/admin/categories").then(res => {
      $scope.items = res.data;
    });
  }
       
  $scope.initialize();
  
})