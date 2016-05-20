/**
 * Created by dandooley on 20/05/16.
 */

var app = angular.module("app", []);

app.controller('HospitalController', ['$http', '$scope', function($http, $scope){
    var hosp = this;

    //ui stuff
    hosp.range = false;
    hosp.date1 = new Date(2020, 0, 1);
    hosp.date2 = new Date(2020, 12, 31);

    hosp.rangeChange = function(){
        console.log(hosp.date1);
        console.log(hosp.date2);
        if (hosp.range){

        } else {

        }
    };


    //data
    hosp.wards = [
        {
            id: 1,
            name: 'Waiting Room',
            capacity: 70,
            bounds: [[368, 126], [503, 359]]
        },
        {
            id: 2,
            name: 'Emergency Department',
            capacity: 30,
            bounds: [[200, 111], [367, 361]]
        },
        {
            id: 3,
            name: 'General',
            capacity: 100,
            bounds: [[343, 650], [597, 1037]]
        },
        {
            id: 4,
            name: 'Ward 1',
            capacity: 40,
            bounds: [[303, 361], [409, 460]]
        },
        {
            id: 5,
            name: 'Ward 2',
            capacity: 30,
            bounds: [[200, 483], [328, 616]]
        },
        {
            id: 6,
            name: 'Ward 3',
            capacity: 40,
            bounds: [[202, 652], [317, 865]]
        },
        {
            id: 7,
            name: 'Ward 4',
            capacity: 10,
            bounds: [[347, 483], [441, 616]]
        }
    ];




    //map stuff

    hosp.map = L.map('map', {
        crs: L.CRS.Simple,
        minZoom: -1.2,
        zoomControl: false,
        dragging: false,
        touchZoom: false,
        scrollWheelZoom: false,
        doubleClickZoom: false
    });

    hosp.map.on({
        click: function(e){
            var point = e.layerPoint;
            console.log(e);
            console.log(point.y + " " + point.x);
            for (var i = 0; i < hosp.wards.length; i++){
                var bounds = hosp.wards[i].bounds;
                if (point.y >= bounds[0][0] && point.y <= bounds[1][0]){
                    if (point.x >= bounds[0][1] && point.x <= bounds[1][1]){
                        hosp.selectedWard = hosp.wards[i];
                        console.log(hosp.selectedWard);
                        $scope.$apply();
                    }
                }
            }
        }
    });

    var bounds = [[0, 0], [1418, 2332]];
    hosp.map.setMaxBounds(bounds);
    var image = L.imageOverlay('images/map.png', bounds).addTo(hosp.map);
    hosp.map.fitBounds(bounds);



    console.log('HospitalController Initialised');
}]);