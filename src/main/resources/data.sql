insert into route(id, name, length, price, description) values (1, 'Высокие Татры(Польша)', '~50km', '$150', 'The trail starts at East Entrance trailhead and climbs 1,000 feet onto the rim with views into Jolley Gulch and the east side slickrock areas. The first stretch of trail offers sweeping views of the slickrock areas on the east side before walking through the high ponderosa forest. After you traverse the rim the views of the Echo Canyon basin open up as you near the East Rim. After hiking over the rim of the canyon you sharply descend 2,300 feet down to the floor of Zion Canyon ending at Weeping Rock, passing through Echo Canyon and down the Observation Point Trail. This area has no established campsites but does require a permit.');
insert into route(id, name, length, price, description) values (2, 'Высокие Татры(Словакия)', '~20km',  '$150','The trail starts at East Entrance trailhead and climbs 1,000 feet onto the rim with views into Jolley Gulch and the east side slickrock areas. The first stretch of trail offers sweeping views of the slickrock areas on the east side before walking through the high ponderosa forest. After you traverse the rim the views of the Echo Canyon basin open up as you near the East Rim. After hiking over the rim of the canyon you sharply descend 2,300 feet down to the floor of Zion Canyon ending at Weeping Rock, passing through Echo Canyon and down the Observation Point Trail. This area has no established campsites but does require a permit.');
insert into route(id, name, length, price, description) values (3, 'Словацкий Рай', '~30km',  '$150','The trail starts at East Entrance trailhead and climbs 1,000 feet onto the rim with views into Jolley Gulch and the east side slickrock areas. The first stretch of trail offers sweeping views of the slickrock areas on the east side before walking through the high ponderosa forest. After you traverse the rim the views of the Echo Canyon basin open up as you near the East Rim. After hiking over the rim of the canyon you sharply descend 2,300 feet down to the floor of Zion Canyon ending at Weeping Rock, passing through Echo Canyon and down the Observation Point Trail. This area has no established campsites but does require a permit.');
-- insert into route(id, name, length, price, description) values (4, 'short route 2', '20km',  '$150','The trail starts at East Entrance trailhead and climbs 1,000 feet onto the rim with views into Jolley Gulch and the east side slickrock areas. The first stretch of trail offers sweeping views of the slickrock areas on the east side before walking through the high ponderosa forest. After you traverse the rim the views of the Echo Canyon basin open up as you near the East Rim. After hiking over the rim of the canyon you sharply descend 2,300 feet down to the floor of Zion Canyon ending at Weeping Rock, passing through Echo Canyon and down the Observation Point Trail. This area has no established campsites but does require a permit.');
-- insert into route(id, name, length, price, description) values (5, 'medium route 2', '30km', '$150', 'The trail starts at East Entrance trailhead and climbs 1,000 feet onto the rim with views into Jolley Gulch and the east side slickrock areas. The first stretch of trail offers sweeping views of the slickrock areas on the east side before walking through the high ponderosa forest. After you traverse the rim the views of the Echo Canyon basin open up as you near the East Rim. After hiking over the rim of the canyon you sharply descend 2,300 feet down to the floor of Zion Canyon ending at Weeping Rock, passing through Echo Canyon and down the Observation Point Trail. This area has no established campsites but does require a permit.');
-- insert into route(id, name, length, price, description) values (6, 'short route 3', '20km',  '$150','The trail starts at East Entrance trailhead and climbs 1,000 feet onto the rim with views into Jolley Gulch and the east side slickrock areas. The first stretch of trail offers sweeping views of the slickrock areas on the east side before walking through the high ponderosa forest. After you traverse the rim the views of the Echo Canyon basin open up as you near the East Rim. After hiking over the rim of the canyon you sharply descend 2,300 feet down to the floor of Zion Canyon ending at Weeping Rock, passing through Echo Canyon and down the Observation Point Trail. This area has no established campsites but does require a permit.');
insert into guide(id, info, name) values (1, 'Deus Ex', 'Лилия Сус');
-- insert into guide(id, info, name) values (2, 'Deus Ex', 'Johnny Walker');
insert into route_time_slot(id, guide_id, route_id, available_date, end_date) values (1, 1, 1, PARSEDATETIME ('31-05-18 11:34:24','dd-MM-yy hh:mm:ss'), PARSEDATETIME ('31-06-18 11:34:24','dd-MM-yy hh:mm:ss'));
insert into route_time_slot(id, guide_id, route_id, available_date, end_date) values (2, 1, 2,  PARSEDATETIME ('28-05-18 11:34:24','dd-MM-yy hh:mm:ss'), PARSEDATETIME ('31-06-18 11:34:24','dd-MM-yy hh:mm:ss'));
insert into route_time_slot(id, guide_id, route_id, available_date, end_date) values (3, 1, 3,  PARSEDATETIME ('28-05-18 11:34:24','dd-MM-yy hh:mm:ss'), PARSEDATETIME ('31-06-18 11:34:24','dd-MM-yy hh:mm:ss'));