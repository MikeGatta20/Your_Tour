<template>
    <div>
        <button v-on:click="generateRoute" type="submit">Generate Route</button>
        <div id="map"></div>
        <div id="panel"></div>
        <p>your route not really</p>
    </div>
</template>

<script>
export default {
    name: "Map",
    props: ["landmarksItinerary"],
    data(){
        return {
            map: null,
            routeService : null,
            routeRendererService: null,
            currentInput : "",
            roundTrip : true,
            mapCenter: { lat: 45.583070, lng: -73.652140},
            locations: [
            
           ],
        }
    },
    methods: {
        initMap(){
            this.map = new window.google.maps.Map(document.getElementById("map"), {
            center: this.mapCenter,
            zoom: 14,
            maxZoom: 20,
            minZoom: 3,
            streetViewControl: true,
            mapTypeControl: true,
            fullscreenControl: true,
            zoomControl: true,
      });
      let noPOIStyle = [
        {
          featureType: "poi",
          elementType: "labels",
          stylers: [{ visibility: "off" }],
        },
      ];
      this.map.setOptions({ styles: noPOIStyle });
        },
     generateRoute() {
        for(let landmark of this.landmarksItinerary){
        let address = landmark.landmark.address
        this.locations.push(address)
       }

        for(let i=0; i < this.locations.length; i++) {

        if (this.locations[i].trim().length === 0) {
            window.alert("Location cannot be empty");
            return;
        }
        }



        const panel = document.getElementById("panel");
        panel.innerHTML = '';
        this.initMap();

        this.routeService = new window.google.maps.DirectionsService();
        this.routeRendererService = new window.google.maps.DirectionsRenderer();
        
        this.routeRendererService.setMap(this.map);
        this.routeRendererService.setPanel(panel);

        let myWaypoints = [];

        /*
        The API expects a single waypoint to be an object like this:
        
        {
            location: "123 somewhere St...",
            stopover: true
        }
        */

        for(let i=1; i < this.locations.length -1; i++) {
        myWaypoints.push( 
            {
            location: this.locations[i],
            stopover: true
            }
        );
        }

        this.routeService.route(
        {
            origin: this.locations[0],
            destination: this.locations[this.locations.length-1],
            waypoints: myWaypoints,
            travelMode: window.google.maps.TravelMode.DRIVING,
            avoidTolls: true,
            optimizeWaypoints: true
        }
        ).then(
            (result) => {
            this.routeRendererService.setDirections(result);
            }
        ). catch(
            (error) => {
            console.log(error + "Could not generate route");
            }
        );

}
    },
    mounted() {
    this.initMap();
    
    
  },
}


</script>

<style>

#grid-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
  "map inputs"
  "directions directions";
}

#map {
  grid-area: map;
  width: 650px;
  height: 400px;
  padding: 25px;
  margin: 25px;
}



#panel {
  grid-area: directions;
}

</style>