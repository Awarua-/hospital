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
            bounds: [[185, 127], [309, 362]]
        },
        {
            id: 2,
            name: 'Emergency Department',
            capacity: 30,
            bounds: [[15, 112], [184, 360]]
        },
        {
            id: 3,
            name: 'General',
            capacity: 100,
            bounds: [[157, 652], [409, 1034]]
        },
        {
            id: 4,
            name: 'Ward 1',
            capacity: 40,
            bounds: [[114, 362], [221, 460]]
        },
        {
            id: 5,
            name: 'Ward 2',
            capacity: 30,
            bounds: [[18, 483], [139, 616]]
        },
        {
            id: 6,
            name: 'Ward 3',
            capacity: 40,
            bounds: [[17, 652], [135, 865]]
        },
        {
            id: 7,
            name: 'Ward 4',
            capacity: 10,
            bounds: [[160, 483], [255, 616]]
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
            var point = e.containerPoint;
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