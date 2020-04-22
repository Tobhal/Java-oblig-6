<template id="new-observation">
    <div>
        <h1>Create new observation</h1>
        <form class="create" @submit="checkForm" :action=`/api/observations/new` method="post">
            <h2> Observation </h2>
            <p>
                <label for="name">Name</label>
                <input type="text" name="name" id="name" v-model="name">
            </p>
            <p>
                <label for="quantity">Quantity</label>
                <input type="number" name="quantity" id="quantity" v-model="quantity">
            </p>
            <p>
                <label for="theDate">Date</label>
                <input type="date" name="theDate" id="theDate" v-model="theDate">
            </p>
            <p>
                <label for="image">Image (url)</label>
                <input type="text" name="image" id="image" v-model="image">
            </p>
            <p>
                <label for="comment">Comment</label>
                <input type="text" name="comment" id="comment" v-model="comment">
            </p>

            <h2> Animal </h2>
            <p>
                <label for="animal_name">Animal name</label>
                <input type="text" name="animal_name" id="animal_name" v-model="animal_name">
            </p>
            <p>
                <label for="animal_scientificName">Animal scientific name</label>
                <input type="text" name="animal_scientificName" id="animal_scientificName" v-model="animal_scientificName">
            </p>
            <p>
                <label for="animal_type">Animal type</label>
                <select name="animal_type" id="animal_type" v-model="animal_type">
                    <option value="amphibian" id="amphibian" v-model="animal_type"> Amphibian </option>
                    <option value="bird" id="bird" v-model="animal_type"> Bird </option>
                    <option value="invertebrate" id="invertebrate" v-model="animal_type"> Invertebrate </option>
                </select>
            </p>
            <p v-if="animal_type === 'amphibian'">
                <label for="animal_mod">Amphibian group</label>
                <select name="animal_mod" id="animal_mod" v-model="animal_mod">
                    <option value="AMPHIBIAN">Amphibian</option>
                    <option value="REPTILIA">Reptilia</option>
                    <option value="MAMMALIA">Mammalia</option>
                </select>
            </p>
            <p v-if="animal_type === 'bird'">
                <label for="animal_mod">Can fly</label>
                <input type="checkbox" name="animal_mod" id="animal_mod" v-model="animal_mod">
            </p>
            <p v-if="animal_type === 'invertebrate'">
                <lable for="animal_mod">Invertebrate</lable>
                <input type="number" name="animal_mod" id="animal_mod" v-model="animal_mod">
            </p>

            <h2>Location</h2>
            <p>
                <lable for="location_planet">Planet</lable>
                <select name="location_planet" id="location_planet" v-model="location_planet">
                    <option v-bind:value="planet.name" v-for="planet in planets">{{planet.name}}</option>
                </select>
            </p>
            <p>
                <label for="location_latitude">Latitude</label>
                <input type="number" step="any" name="location_latitude" id="location_latitude" v-model="location_latitude">
            </p>
            <p>
                <label for="location_longitude">Longitude</label>
                <input type="number" step="any" name="location_longitude" id="location_longitude" v-model="location_longitude">
            </p>
            <p>
                <label for="location_biomes">Biome</label>
                <select name="location_biomes" id="location_biomes" v-model="location_biomes">
                    <option value="forest">Forest</option>
                    <option value="grassland">Grassland</option>
                    <option value="freshwater">Freshwater</option>
                    <option value="marine">Marine</option>
                    <option value="desert">Desert</option>
                    <option value="tundra">Tundra</option>
                </select>
            </p>

            <p>
                <input type="submit" value="Create">
            </p>

<!--
            <p>
                <label for="animal">Animal</label>
                <select name="animal" id="animal" v-model="animal">
                    <option v-bind:value="animal.name" v-for="animal in animals">{{animal.name}}</option>
                </select>
            </p>

            <p>
                <label for="location">Location</label>
                <select name="location" id="location" v-model="location">
                    <option v-bind:value="location.name" v-for="location in locations">{{location.planet.name}}</option>
                </select>
            </p>
-->
        </form>
    </div>
</template>
<script>
    Vue.component("new-observation", {
        template: "#new-observation",
        data: () => ({
            name: null,
            quantity: null,
            image: null,
            comment: null,

            animal_name: null,
            animal_scientificName: null,
            animal_type: null,
            animal_mod: null,

            theDate: null,

            location_latitude: null,
            location_longitude: null,
            location_biomes: [],
            location_planet: null,


            animals: [],
            locations: [],
            planets: [],
        }),
        created() {
            fetch(`/api/animals`)
                .then(res => res.json())
                .then(res => this.animals = res)
                .catch(() => alert("error while fetching animals"));
            fetch(`/api/locations`)
                .then(res => res.json())
                .then(res => this.locations = res)
                .catch(() => alert("error while fetching locations"));
            fetch('/api/planets')
                .then(res => res.json())
                .then(res => this.planets = res)
                .catch(() => alert("error while fetching planets"));
        },
        methods:{
            checkForm:function (e) {
                const urlRegex = "/^(?:(?:(?:https?|ftp):)?\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\\.(?:[a-z\u00a1-\uffff]{2,})))(?::\\d{2,5})?(?:[/?#]\\S*)?$/i";
                e.prevemtDefault();
            }
        }
    })
</script>
<style>
    p {
        height: auto;
    }

    select {
        margin: 0;
    }
</style>