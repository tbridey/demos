/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
$(document).ready(function() {

    $(".click-title").mouseenter( function(    e){
        e.preventDefault();
        this.style.cursor="pointer";
    });
    $(".click-title").mousedown( function(event){
        event.preventDefault();
    });

    // Ugly code while this script is shared among several pages
    try{
        refreshHitsPerSecond(true);
    } catch(e){}
    try{
        refreshResponseTimeOverTime(true);
    } catch(e){}
    try{
        refreshResponseTimePercentiles();
    } catch(e){}
});


var responseTimePercentilesInfos = {
        data: {"result": {"minY": 0.0, "minX": 0.0, "maxY": 3816.0, "series": [{"data": [[0.0, 0.0], [0.1, 4.0], [0.2, 5.0], [0.3, 7.0], [0.4, 7.0], [0.5, 10.0], [0.6, 11.0], [0.7, 13.0], [0.8, 14.0], [0.9, 15.0], [1.0, 16.0], [1.1, 16.0], [1.2, 18.0], [1.3, 18.0], [1.4, 19.0], [1.5, 20.0], [1.6, 21.0], [1.7, 21.0], [1.8, 22.0], [1.9, 23.0], [2.0, 24.0], [2.1, 25.0], [2.2, 26.0], [2.3, 27.0], [2.4, 28.0], [2.5, 28.0], [2.6, 29.0], [2.7, 30.0], [2.8, 31.0], [2.9, 31.0], [3.0, 32.0], [3.1, 33.0], [3.2, 33.0], [3.3, 34.0], [3.4, 34.0], [3.5, 35.0], [3.6, 35.0], [3.7, 36.0], [3.8, 37.0], [3.9, 37.0], [4.0, 38.0], [4.1, 38.0], [4.2, 39.0], [4.3, 39.0], [4.4, 40.0], [4.5, 41.0], [4.6, 41.0], [4.7, 41.0], [4.8, 42.0], [4.9, 43.0], [5.0, 43.0], [5.1, 44.0], [5.2, 44.0], [5.3, 45.0], [5.4, 45.0], [5.5, 46.0], [5.6, 47.0], [5.7, 47.0], [5.8, 48.0], [5.9, 48.0], [6.0, 49.0], [6.1, 49.0], [6.2, 50.0], [6.3, 50.0], [6.4, 51.0], [6.5, 51.0], [6.6, 51.0], [6.7, 52.0], [6.8, 52.0], [6.9, 53.0], [7.0, 53.0], [7.1, 53.0], [7.2, 54.0], [7.3, 54.0], [7.4, 55.0], [7.5, 55.0], [7.6, 55.0], [7.7, 55.0], [7.8, 56.0], [7.9, 56.0], [8.0, 56.0], [8.1, 57.0], [8.2, 57.0], [8.3, 57.0], [8.4, 58.0], [8.5, 58.0], [8.6, 58.0], [8.7, 58.0], [8.8, 59.0], [8.9, 59.0], [9.0, 60.0], [9.1, 60.0], [9.2, 60.0], [9.3, 61.0], [9.4, 61.0], [9.5, 61.0], [9.6, 61.0], [9.7, 62.0], [9.8, 62.0], [9.9, 62.0], [10.0, 62.0], [10.1, 63.0], [10.2, 63.0], [10.3, 63.0], [10.4, 63.0], [10.5, 64.0], [10.6, 64.0], [10.7, 64.0], [10.8, 65.0], [10.9, 65.0], [11.0, 65.0], [11.1, 66.0], [11.2, 66.0], [11.3, 66.0], [11.4, 66.0], [11.5, 67.0], [11.6, 67.0], [11.7, 67.0], [11.8, 67.0], [11.9, 68.0], [12.0, 68.0], [12.1, 68.0], [12.2, 68.0], [12.3, 68.0], [12.4, 69.0], [12.5, 69.0], [12.6, 69.0], [12.7, 69.0], [12.8, 70.0], [12.9, 70.0], [13.0, 70.0], [13.1, 70.0], [13.2, 71.0], [13.3, 71.0], [13.4, 71.0], [13.5, 71.0], [13.6, 71.0], [13.7, 71.0], [13.8, 72.0], [13.9, 72.0], [14.0, 72.0], [14.1, 72.0], [14.2, 73.0], [14.3, 73.0], [14.4, 73.0], [14.5, 73.0], [14.6, 74.0], [14.7, 74.0], [14.8, 74.0], [14.9, 74.0], [15.0, 74.0], [15.1, 74.0], [15.2, 75.0], [15.3, 75.0], [15.4, 75.0], [15.5, 75.0], [15.6, 75.0], [15.7, 75.0], [15.8, 76.0], [15.9, 76.0], [16.0, 76.0], [16.1, 76.0], [16.2, 76.0], [16.3, 77.0], [16.4, 77.0], [16.5, 77.0], [16.6, 77.0], [16.7, 77.0], [16.8, 77.0], [16.9, 77.0], [17.0, 78.0], [17.1, 78.0], [17.2, 78.0], [17.3, 78.0], [17.4, 78.0], [17.5, 78.0], [17.6, 78.0], [17.7, 79.0], [17.8, 79.0], [17.9, 79.0], [18.0, 79.0], [18.1, 79.0], [18.2, 79.0], [18.3, 79.0], [18.4, 79.0], [18.5, 79.0], [18.6, 80.0], [18.7, 80.0], [18.8, 80.0], [18.9, 80.0], [19.0, 80.0], [19.1, 80.0], [19.2, 80.0], [19.3, 80.0], [19.4, 80.0], [19.5, 80.0], [19.6, 81.0], [19.7, 81.0], [19.8, 81.0], [19.9, 81.0], [20.0, 81.0], [20.1, 81.0], [20.2, 81.0], [20.3, 81.0], [20.4, 81.0], [20.5, 82.0], [20.6, 82.0], [20.7, 82.0], [20.8, 82.0], [20.9, 82.0], [21.0, 82.0], [21.1, 82.0], [21.2, 82.0], [21.3, 82.0], [21.4, 82.0], [21.5, 82.0], [21.6, 83.0], [21.7, 83.0], [21.8, 83.0], [21.9, 83.0], [22.0, 83.0], [22.1, 83.0], [22.2, 83.0], [22.3, 83.0], [22.4, 83.0], [22.5, 84.0], [22.6, 84.0], [22.7, 84.0], [22.8, 84.0], [22.9, 84.0], [23.0, 84.0], [23.1, 84.0], [23.2, 84.0], [23.3, 85.0], [23.4, 85.0], [23.5, 85.0], [23.6, 85.0], [23.7, 85.0], [23.8, 85.0], [23.9, 85.0], [24.0, 85.0], [24.1, 85.0], [24.2, 86.0], [24.3, 86.0], [24.4, 86.0], [24.5, 86.0], [24.6, 86.0], [24.7, 86.0], [24.8, 86.0], [24.9, 86.0], [25.0, 86.0], [25.1, 87.0], [25.2, 87.0], [25.3, 87.0], [25.4, 87.0], [25.5, 87.0], [25.6, 87.0], [25.7, 87.0], [25.8, 87.0], [25.9, 87.0], [26.0, 87.0], [26.1, 88.0], [26.2, 88.0], [26.3, 88.0], [26.4, 88.0], [26.5, 88.0], [26.6, 88.0], [26.7, 88.0], [26.8, 88.0], [26.9, 88.0], [27.0, 88.0], [27.1, 88.0], [27.2, 89.0], [27.3, 89.0], [27.4, 89.0], [27.5, 89.0], [27.6, 89.0], [27.7, 89.0], [27.8, 89.0], [27.9, 89.0], [28.0, 89.0], [28.1, 89.0], [28.2, 90.0], [28.3, 90.0], [28.4, 90.0], [28.5, 90.0], [28.6, 90.0], [28.7, 90.0], [28.8, 90.0], [28.9, 90.0], [29.0, 90.0], [29.1, 90.0], [29.2, 90.0], [29.3, 91.0], [29.4, 91.0], [29.5, 91.0], [29.6, 91.0], [29.7, 91.0], [29.8, 91.0], [29.9, 91.0], [30.0, 91.0], [30.1, 91.0], [30.2, 91.0], [30.3, 91.0], [30.4, 92.0], [30.5, 92.0], [30.6, 92.0], [30.7, 92.0], [30.8, 92.0], [30.9, 92.0], [31.0, 92.0], [31.1, 93.0], [31.2, 93.0], [31.3, 93.0], [31.4, 93.0], [31.5, 93.0], [31.6, 93.0], [31.7, 93.0], [31.8, 93.0], [31.9, 94.0], [32.0, 94.0], [32.1, 94.0], [32.2, 94.0], [32.3, 94.0], [32.4, 94.0], [32.5, 94.0], [32.6, 94.0], [32.7, 95.0], [32.8, 95.0], [32.9, 95.0], [33.0, 95.0], [33.1, 95.0], [33.2, 95.0], [33.3, 95.0], [33.4, 96.0], [33.5, 96.0], [33.6, 96.0], [33.7, 96.0], [33.8, 96.0], [33.9, 96.0], [34.0, 96.0], [34.1, 97.0], [34.2, 97.0], [34.3, 97.0], [34.4, 97.0], [34.5, 97.0], [34.6, 97.0], [34.7, 97.0], [34.8, 97.0], [34.9, 97.0], [35.0, 97.0], [35.1, 98.0], [35.2, 98.0], [35.3, 98.0], [35.4, 98.0], [35.5, 98.0], [35.6, 98.0], [35.7, 98.0], [35.8, 98.0], [35.9, 99.0], [36.0, 99.0], [36.1, 99.0], [36.2, 99.0], [36.3, 99.0], [36.4, 99.0], [36.5, 99.0], [36.6, 100.0], [36.7, 100.0], [36.8, 100.0], [36.9, 100.0], [37.0, 100.0], [37.1, 100.0], [37.2, 100.0], [37.3, 101.0], [37.4, 101.0], [37.5, 101.0], [37.6, 101.0], [37.7, 101.0], [37.8, 101.0], [37.9, 101.0], [38.0, 101.0], [38.1, 102.0], [38.2, 102.0], [38.3, 102.0], [38.4, 102.0], [38.5, 102.0], [38.6, 102.0], [38.7, 102.0], [38.8, 103.0], [38.9, 103.0], [39.0, 103.0], [39.1, 103.0], [39.2, 103.0], [39.3, 103.0], [39.4, 103.0], [39.5, 104.0], [39.6, 104.0], [39.7, 104.0], [39.8, 104.0], [39.9, 104.0], [40.0, 104.0], [40.1, 105.0], [40.2, 105.0], [40.3, 105.0], [40.4, 105.0], [40.5, 105.0], [40.6, 105.0], [40.7, 105.0], [40.8, 106.0], [40.9, 106.0], [41.0, 106.0], [41.1, 106.0], [41.2, 106.0], [41.3, 106.0], [41.4, 107.0], [41.5, 107.0], [41.6, 107.0], [41.7, 107.0], [41.8, 107.0], [41.9, 108.0], [42.0, 108.0], [42.1, 108.0], [42.2, 108.0], [42.3, 108.0], [42.4, 108.0], [42.5, 109.0], [42.6, 109.0], [42.7, 109.0], [42.8, 109.0], [42.9, 109.0], [43.0, 109.0], [43.1, 110.0], [43.2, 110.0], [43.3, 110.0], [43.4, 110.0], [43.5, 110.0], [43.6, 111.0], [43.7, 111.0], [43.8, 111.0], [43.9, 111.0], [44.0, 111.0], [44.1, 112.0], [44.2, 112.0], [44.3, 112.0], [44.4, 112.0], [44.5, 112.0], [44.6, 113.0], [44.7, 113.0], [44.8, 113.0], [44.9, 113.0], [45.0, 113.0], [45.1, 114.0], [45.2, 114.0], [45.3, 114.0], [45.4, 114.0], [45.5, 115.0], [45.6, 115.0], [45.7, 115.0], [45.8, 115.0], [45.9, 116.0], [46.0, 116.0], [46.1, 116.0], [46.2, 116.0], [46.3, 117.0], [46.4, 117.0], [46.5, 117.0], [46.6, 117.0], [46.7, 117.0], [46.8, 117.0], [46.9, 118.0], [47.0, 118.0], [47.1, 118.0], [47.2, 118.0], [47.3, 118.0], [47.4, 119.0], [47.5, 119.0], [47.6, 119.0], [47.7, 119.0], [47.8, 119.0], [47.9, 120.0], [48.0, 120.0], [48.1, 120.0], [48.2, 120.0], [48.3, 120.0], [48.4, 121.0], [48.5, 121.0], [48.6, 121.0], [48.7, 121.0], [48.8, 121.0], [48.9, 121.0], [49.0, 122.0], [49.1, 122.0], [49.2, 122.0], [49.3, 122.0], [49.4, 123.0], [49.5, 123.0], [49.6, 123.0], [49.7, 123.0], [49.8, 124.0], [49.9, 124.0], [50.0, 124.0], [50.1, 124.0], [50.2, 125.0], [50.3, 125.0], [50.4, 125.0], [50.5, 126.0], [50.6, 126.0], [50.7, 126.0], [50.8, 126.0], [50.9, 127.0], [51.0, 127.0], [51.1, 127.0], [51.2, 127.0], [51.3, 127.0], [51.4, 128.0], [51.5, 128.0], [51.6, 128.0], [51.7, 128.0], [51.8, 128.0], [51.9, 129.0], [52.0, 129.0], [52.1, 129.0], [52.2, 129.0], [52.3, 130.0], [52.4, 130.0], [52.5, 130.0], [52.6, 130.0], [52.7, 130.0], [52.8, 131.0], [52.9, 131.0], [53.0, 131.0], [53.1, 131.0], [53.2, 132.0], [53.3, 132.0], [53.4, 132.0], [53.5, 133.0], [53.6, 133.0], [53.7, 133.0], [53.8, 133.0], [53.9, 133.0], [54.0, 134.0], [54.1, 134.0], [54.2, 134.0], [54.3, 134.0], [54.4, 135.0], [54.5, 135.0], [54.6, 135.0], [54.7, 135.0], [54.8, 136.0], [54.9, 136.0], [55.0, 136.0], [55.1, 137.0], [55.2, 137.0], [55.3, 137.0], [55.4, 137.0], [55.5, 138.0], [55.6, 138.0], [55.7, 138.0], [55.8, 138.0], [55.9, 139.0], [56.0, 139.0], [56.1, 139.0], [56.2, 139.0], [56.3, 140.0], [56.4, 140.0], [56.5, 140.0], [56.6, 141.0], [56.7, 141.0], [56.8, 141.0], [56.9, 141.0], [57.0, 142.0], [57.1, 142.0], [57.2, 142.0], [57.3, 143.0], [57.4, 143.0], [57.5, 143.0], [57.6, 143.0], [57.7, 144.0], [57.8, 144.0], [57.9, 144.0], [58.0, 145.0], [58.1, 145.0], [58.2, 145.0], [58.3, 146.0], [58.4, 146.0], [58.5, 147.0], [58.6, 147.0], [58.7, 147.0], [58.8, 147.0], [58.9, 148.0], [59.0, 148.0], [59.1, 148.0], [59.2, 149.0], [59.3, 149.0], [59.4, 149.0], [59.5, 150.0], [59.6, 150.0], [59.7, 150.0], [59.8, 150.0], [59.9, 151.0], [60.0, 151.0], [60.1, 151.0], [60.2, 151.0], [60.3, 152.0], [60.4, 152.0], [60.5, 152.0], [60.6, 153.0], [60.7, 153.0], [60.8, 153.0], [60.9, 154.0], [61.0, 154.0], [61.1, 154.0], [61.2, 155.0], [61.3, 155.0], [61.4, 155.0], [61.5, 156.0], [61.6, 156.0], [61.7, 157.0], [61.8, 157.0], [61.9, 157.0], [62.0, 158.0], [62.1, 158.0], [62.2, 158.0], [62.3, 159.0], [62.4, 159.0], [62.5, 159.0], [62.6, 160.0], [62.7, 160.0], [62.8, 160.0], [62.9, 161.0], [63.0, 161.0], [63.1, 162.0], [63.2, 162.0], [63.3, 162.0], [63.4, 163.0], [63.5, 163.0], [63.6, 164.0], [63.7, 164.0], [63.8, 165.0], [63.9, 165.0], [64.0, 166.0], [64.1, 166.0], [64.2, 167.0], [64.3, 167.0], [64.4, 168.0], [64.5, 168.0], [64.6, 169.0], [64.7, 169.0], [64.8, 169.0], [64.9, 170.0], [65.0, 170.0], [65.1, 170.0], [65.2, 171.0], [65.3, 171.0], [65.4, 171.0], [65.5, 172.0], [65.6, 172.0], [65.7, 172.0], [65.8, 173.0], [65.9, 173.0], [66.0, 174.0], [66.1, 174.0], [66.2, 175.0], [66.3, 175.0], [66.4, 176.0], [66.5, 176.0], [66.6, 177.0], [66.7, 177.0], [66.8, 178.0], [66.9, 178.0], [67.0, 179.0], [67.1, 180.0], [67.2, 180.0], [67.3, 181.0], [67.4, 181.0], [67.5, 182.0], [67.6, 182.0], [67.7, 183.0], [67.8, 184.0], [67.9, 184.0], [68.0, 185.0], [68.1, 186.0], [68.2, 187.0], [68.3, 187.0], [68.4, 188.0], [68.5, 189.0], [68.6, 189.0], [68.7, 190.0], [68.8, 190.0], [68.9, 191.0], [69.0, 192.0], [69.1, 192.0], [69.2, 193.0], [69.3, 194.0], [69.4, 195.0], [69.5, 195.0], [69.6, 196.0], [69.7, 197.0], [69.8, 198.0], [69.9, 199.0], [70.0, 200.0], [70.1, 201.0], [70.2, 202.0], [70.3, 203.0], [70.4, 204.0], [70.5, 204.0], [70.6, 205.0], [70.7, 206.0], [70.8, 206.0], [70.9, 207.0], [71.0, 208.0], [71.1, 209.0], [71.2, 210.0], [71.3, 210.0], [71.4, 211.0], [71.5, 212.0], [71.6, 213.0], [71.7, 214.0], [71.8, 215.0], [71.9, 216.0], [72.0, 217.0], [72.1, 219.0], [72.2, 220.0], [72.3, 221.0], [72.4, 222.0], [72.5, 223.0], [72.6, 224.0], [72.7, 226.0], [72.8, 228.0], [72.9, 230.0], [73.0, 231.0], [73.1, 232.0], [73.2, 234.0], [73.3, 235.0], [73.4, 236.0], [73.5, 239.0], [73.6, 240.0], [73.7, 242.0], [73.8, 244.0], [73.9, 246.0], [74.0, 247.0], [74.1, 249.0], [74.2, 252.0], [74.3, 254.0], [74.4, 256.0], [74.5, 258.0], [74.6, 260.0], [74.7, 263.0], [74.8, 265.0], [74.9, 268.0], [75.0, 270.0], [75.1, 272.0], [75.2, 274.0], [75.3, 276.0], [75.4, 277.0], [75.5, 279.0], [75.6, 281.0], [75.7, 285.0], [75.8, 291.0], [75.9, 300.0], [76.0, 308.0], [76.1, 314.0], [76.2, 324.0], [76.3, 333.0], [76.4, 338.0], [76.5, 344.0], [76.6, 348.0], [76.7, 352.0], [76.8, 359.0], [76.9, 363.0], [77.0, 390.0], [77.1, 406.0], [77.2, 417.0], [77.3, 427.0], [77.4, 441.0], [77.5, 468.0], [77.6, 476.0], [77.7, 490.0], [77.8, 507.0], [77.9, 531.0], [78.0, 547.0], [78.1, 556.0], [78.2, 560.0], [78.3, 608.0], [78.4, 883.0], [78.5, 919.0], [78.6, 932.0], [78.7, 944.0], [78.8, 957.0], [78.9, 968.0], [79.0, 979.0], [79.1, 1001.0], [79.2, 1022.0], [79.3, 1048.0], [79.4, 1071.0], [79.5, 1096.0], [79.6, 1110.0], [79.7, 1122.0], [79.8, 1136.0], [79.9, 1143.0], [80.0, 1152.0], [80.1, 1163.0], [80.2, 1169.0], [80.3, 1180.0], [80.4, 1185.0], [80.5, 1191.0], [80.6, 1194.0], [80.7, 1199.0], [80.8, 1203.0], [80.9, 1208.0], [81.0, 1211.0], [81.1, 1219.0], [81.2, 1223.0], [81.3, 1230.0], [81.4, 1234.0], [81.5, 1240.0], [81.6, 1245.0], [81.7, 1252.0], [81.8, 1257.0], [81.9, 1261.0], [82.0, 1264.0], [82.1, 1269.0], [82.2, 1275.0], [82.3, 1279.0], [82.4, 1283.0], [82.5, 1287.0], [82.6, 1290.0], [82.7, 1296.0], [82.8, 1299.0], [82.9, 1303.0], [83.0, 1307.0], [83.1, 1310.0], [83.2, 1314.0], [83.3, 1318.0], [83.4, 1323.0], [83.5, 1326.0], [83.6, 1329.0], [83.7, 1332.0], [83.8, 1336.0], [83.9, 1339.0], [84.0, 1341.0], [84.1, 1346.0], [84.2, 1351.0], [84.3, 1354.0], [84.4, 1357.0], [84.5, 1365.0], [84.6, 1369.0], [84.7, 1373.0], [84.8, 1376.0], [84.9, 1379.0], [85.0, 1382.0], [85.1, 1386.0], [85.2, 1389.0], [85.3, 1393.0], [85.4, 1397.0], [85.5, 1400.0], [85.6, 1404.0], [85.7, 1407.0], [85.8, 1411.0], [85.9, 1415.0], [86.0, 1419.0], [86.1, 1422.0], [86.2, 1425.0], [86.3, 1429.0], [86.4, 1432.0], [86.5, 1437.0], [86.6, 1441.0], [86.7, 1448.0], [86.8, 1456.0], [86.9, 1459.0], [87.0, 1463.0], [87.1, 1470.0], [87.2, 1476.0], [87.3, 1480.0], [87.4, 1484.0], [87.5, 1488.0], [87.6, 1493.0], [87.7, 1497.0], [87.8, 1501.0], [87.9, 1508.0], [88.0, 1512.0], [88.1, 1517.0], [88.2, 1521.0], [88.3, 1524.0], [88.4, 1527.0], [88.5, 1531.0], [88.6, 1533.0], [88.7, 1536.0], [88.8, 1540.0], [88.9, 1542.0], [89.0, 1545.0], [89.1, 1548.0], [89.2, 1551.0], [89.3, 1556.0], [89.4, 1559.0], [89.5, 1561.0], [89.6, 1565.0], [89.7, 1567.0], [89.8, 1570.0], [89.9, 1574.0], [90.0, 1578.0], [90.1, 1582.0], [90.2, 1585.0], [90.3, 1589.0], [90.4, 1592.0], [90.5, 1597.0], [90.6, 1604.0], [90.7, 1608.0], [90.8, 1612.0], [90.9, 1616.0], [91.0, 1622.0], [91.1, 1626.0], [91.2, 1631.0], [91.3, 1635.0], [91.4, 1639.0], [91.5, 1642.0], [91.6, 1644.0], [91.7, 1651.0], [91.8, 1657.0], [91.9, 1663.0], [92.0, 1666.0], [92.1, 1673.0], [92.2, 1678.0], [92.3, 1682.0], [92.4, 1687.0], [92.5, 1690.0], [92.6, 1697.0], [92.7, 1700.0], [92.8, 1705.0], [92.9, 1709.0], [93.0, 1713.0], [93.1, 1719.0], [93.2, 1725.0], [93.3, 1730.0], [93.4, 1735.0], [93.5, 1740.0], [93.6, 1744.0], [93.7, 1748.0], [93.8, 1754.0], [93.9, 1761.0], [94.0, 1767.0], [94.1, 1778.0], [94.2, 1782.0], [94.3, 1786.0], [94.4, 1793.0], [94.5, 1797.0], [94.6, 1803.0], [94.7, 1812.0], [94.8, 1819.0], [94.9, 1826.0], [95.0, 1830.0], [95.1, 1836.0], [95.2, 1844.0], [95.3, 1849.0], [95.4, 1858.0], [95.5, 1864.0], [95.6, 1868.0], [95.7, 1871.0], [95.8, 1879.0], [95.9, 1885.0], [96.0, 1890.0], [96.1, 1896.0], [96.2, 1899.0], [96.3, 1904.0], [96.4, 1907.0], [96.5, 1913.0], [96.6, 1922.0], [96.7, 1931.0], [96.8, 1939.0], [96.9, 1946.0], [97.0, 1956.0], [97.1, 1965.0], [97.2, 1970.0], [97.3, 1984.0], [97.4, 2006.0], [97.5, 2029.0], [97.6, 2058.0], [97.7, 2083.0], [97.8, 2108.0], [97.9, 2122.0], [98.0, 2142.0], [98.1, 2159.0], [98.2, 2170.0], [98.3, 2186.0], [98.4, 2206.0], [98.5, 2238.0], [98.6, 2283.0], [98.7, 2353.0], [98.8, 2507.0], [98.9, 2555.0], [99.0, 2700.0], [99.1, 2782.0], [99.2, 2813.0], [99.3, 2878.0], [99.4, 2904.0], [99.5, 2919.0], [99.6, 2937.0], [99.7, 2983.0], [99.8, 3047.0], [99.9, 3422.0], [100.0, 3816.0]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "maxX": 100.0, "title": "Response Time Percentiles"}},
        getOptions: function() {
            return {
                series: {
                    points: { show: false }
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimePercentiles'
                },
                xaxis: {
                    tickDecimals: 1,
                    axisLabel: "Percentiles",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Percentile value in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : %x.2 percentile was %y ms"
                },
                selection: { mode: "xy" },
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesResponseTimePercentiles"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimesPercentiles"), dataset, options);
            // setup overview
            $.plot($("#overviewResponseTimesPercentiles"), dataset, prepareOverviewOptions(options));
        }
};

/**
 * @param elementId Id of element where we display message
 */
function setEmptyGraph(elementId) {
    $(function() {
        $(elementId).text("No graph series with filter="+seriesFilter);
    });
}

// Response times percentiles
function refreshResponseTimePercentiles() {
    var infos = responseTimePercentilesInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimePercentiles");
        return;
    }
    if (isGraph($("#flotResponseTimesPercentiles"))){
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesResponseTimePercentiles");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimesPercentiles", "#overviewResponseTimesPercentiles");
        $('#bodyResponseTimePercentiles .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var responseTimeDistributionInfos = {
        data: {"result": {"minY": 1.0, "minX": 0.0, "maxY": 4899.0, "series": [{"data": [[0.0, 4899.0], [600.0, 13.0], [800.0, 1.0], [900.0, 92.0], [1000.0, 61.0], [1100.0, 156.0], [1200.0, 280.0], [1300.0, 360.0], [1400.0, 300.0], [1500.0, 376.0], [100.0, 4466.0], [1600.0, 288.0], [1700.0, 247.0], [1800.0, 224.0], [1900.0, 157.0], [2000.0, 54.0], [2100.0, 79.0], [2200.0, 34.0], [2300.0, 13.0], [2400.0, 10.0], [2500.0, 21.0], [2600.0, 6.0], [2800.0, 31.0], [2700.0, 19.0], [2900.0, 48.0], [3000.0, 18.0], [3100.0, 2.0], [200.0, 798.0], [3200.0, 2.0], [3400.0, 5.0], [3500.0, 4.0], [3600.0, 3.0], [3800.0, 2.0], [300.0, 156.0], [400.0, 92.0], [500.0, 73.0]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 100, "maxX": 3800.0, "title": "Response Time Distribution"}},
        getOptions: function() {
            var granularity = this.data.result.granularity;
            return {
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimeDistribution'
                },
                xaxis:{
                    axisLabel: "Response times in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of responses",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                bars : {
                    show: true,
                    barWidth: this.data.result.granularity
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: function(label, xval, yval, flotItem){
                        return yval + " responses for " + label + " were between " + xval + " and " + (xval + granularity) + " ms";
                    }
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimeDistribution"), prepareData(data.result.series, $("#choicesResponseTimeDistribution")), options);
        }

};

// Response time distribution
function refreshResponseTimeDistribution() {
    var infos = responseTimeDistributionInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimeDistribution");
        return;
    }
    if (isGraph($("#flotResponseTimeDistribution"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesResponseTimeDistribution");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        $('#footerResponseTimeDistribution .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var syntheticResponseTimeDistributionInfos = {
        data: {"result": {"minY": 240.0, "minX": 0.0, "ticks": [[0, "Requests having \nresponse time <= 500ms"], [1, "Requests having \nresponse time > 500ms and <= 1,500ms"], [2, "Requests having \nresponse time > 1,500ms"], [3, "Requests in error"]], "maxY": 10411.0, "series": [{"data": [[0.0, 10411.0]], "color": "#9ACD32", "isOverall": false, "label": "Requests having \nresponse time <= 500ms", "isController": false}, {"data": [[1.0, 1229.0]], "color": "yellow", "isOverall": false, "label": "Requests having \nresponse time > 500ms and <= 1,500ms", "isController": false}, {"data": [[2.0, 1510.0]], "color": "orange", "isOverall": false, "label": "Requests having \nresponse time > 1,500ms", "isController": false}, {"data": [[3.0, 240.0]], "color": "#FF6347", "isOverall": false, "label": "Requests in error", "isController": false}], "supportsControllersDiscrimination": false, "maxX": 3.0, "title": "Synthetic Response Times Distribution"}},
        getOptions: function() {
            return {
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendSyntheticResponseTimeDistribution'
                },
                xaxis:{
                    axisLabel: "Response times ranges",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                    tickLength:0,
                    min:-0.5,
                    max:3.5
                },
                yaxis: {
                    axisLabel: "Number of responses",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                bars : {
                    show: true,
                    align: "center",
                    barWidth: 0.25,
                    fill:.75
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: function(label, xval, yval, flotItem){
                        return yval + " " + label;
                    }
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var options = this.getOptions();
            prepareOptions(options, data);
            options.xaxis.ticks = data.result.ticks;
            $.plot($("#flotSyntheticResponseTimeDistribution"), prepareData(data.result.series, $("#choicesSyntheticResponseTimeDistribution")), options);
        }

};

// Response time distribution
function refreshSyntheticResponseTimeDistribution() {
    var infos = syntheticResponseTimeDistributionInfos;
    prepareSeries(infos.data, true);
    if (isGraph($("#flotSyntheticResponseTimeDistribution"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesSyntheticResponseTimeDistribution");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        $('#footerSyntheticResponseTimeDistribution .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var activeThreadsOverTimeInfos = {
        data: {"result": {"minY": 187.8735199138862, "minX": 1.6009758E12, "maxY": 197.9675418647921, "series": [{"data": [[1.6009758E12, 187.8735199138862], [1.60097586E12, 197.9675418647921]], "isOverall": false, "label": "Ramp to 200 for 30 seconds", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.60097586E12, "title": "Active Threads Over Time"}},
        getOptions: function() {
            return {
                series: {
                    stack: true,
                    lines: {
                        show: true,
                        fill: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of active threads",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 6,
                    show: true,
                    container: '#legendActiveThreadsOverTime'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                selection: {
                    mode: 'xy'
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : At %x there were %y active threads"
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesActiveThreadsOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotActiveThreadsOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewActiveThreadsOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Active Threads Over Time
function refreshActiveThreadsOverTime(fixTimestamps) {
    var infos = activeThreadsOverTimeInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -25200000);
    }
    if(isGraph($("#flotActiveThreadsOverTime"))) {
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesActiveThreadsOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotActiveThreadsOverTime", "#overviewActiveThreadsOverTime");
        $('#footerActiveThreadsOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var timeVsThreadsInfos = {
        data: {"result": {"minY": 34.58620689655172, "minX": 3.0, "maxY": 3243.0, "series": [{"data": [[3.0, 1665.6666666666667], [5.0, 1655.5], [6.0, 1559.0], [7.0, 1568.0], [10.0, 1631.0], [15.0, 1612.857142857143], [16.0, 1633.0], [17.0, 1616.0], [19.0, 1620.0], [20.0, 1614.0], [21.0, 1628.0], [22.0, 1494.0], [26.0, 1551.75], [29.0, 1567.0], [32.0, 1544.0], [37.0, 1577.0], [39.0, 1545.5], [40.0, 1530.0], [43.0, 1532.5], [42.0, 1579.0], [47.0, 1587.5], [48.0, 1541.0], [51.0, 1568.0], [50.0, 1553.0], [53.0, 1483.0], [55.0, 1477.0], [54.0, 1589.0], [58.0, 1500.0], [60.0, 1536.0], [63.0, 1494.0], [62.0, 1567.0], [70.0, 1521.142857142857], [75.0, 1514.3333333333333], [74.0, 1485.0], [79.0, 1501.0], [76.0, 1532.0], [82.0, 1373.0], [81.0, 1410.0], [80.0, 1460.0], [87.0, 1288.0], [86.0, 1283.5], [84.0, 1332.0], [91.0, 3243.0], [90.0, 1242.0], [89.0, 1243.0], [95.0, 3073.0], [94.0, 3118.0], [93.0, 3171.0], [92.0, 3229.0], [99.0, 2328.6666666666665], [97.0, 3065.5], [100.0, 670.6], [103.0, 1345.0], [102.0, 3035.0], [101.0, 3060.0], [105.0, 1772.0], [106.0, 1036.5], [107.0, 1542.1666666666665], [108.0, 679.3571428571429], [109.0, 532.25], [110.0, 1779.0], [111.0, 867.0], [112.0, 805.5], [113.0, 1537.0], [114.0, 287.0], [115.0, 84.0], [116.0, 1284.625], [117.0, 308.0], [118.0, 791.625], [119.0, 362.27272727272725], [120.0, 428.44444444444446], [121.0, 655.6666666666667], [123.0, 178.55555555555554], [122.0, 2904.0], [125.0, 743.0], [126.0, 142.75], [127.0, 653.5], [124.0, 2908.0], [128.0, 271.4], [129.0, 116.0], [130.0, 773.5], [131.0, 548.0], [132.0, 912.6], [133.0, 211.21212121212125], [134.0, 83.0], [135.0, 104.5], [136.0, 895.0666666666666], [137.0, 151.27777777777777], [138.0, 52.0], [139.0, 1025.1666666666665], [140.0, 83.0], [141.0, 320.5], [142.0, 139.0], [143.0, 170.41176470588235], [144.0, 971.5], [145.0, 215.83333333333331], [146.0, 79.6], [147.0, 1076.6666666666665], [148.0, 1087.7600000000002], [149.0, 307.08333333333337], [150.0, 235.8181818181818], [151.0, 144.5], [152.0, 854.7777777777778], [153.0, 157.25], [154.0, 34.58620689655172], [155.0, 50.166666666666664], [156.0, 79.33333333333333], [157.0, 85.71428571428571], [158.0, 658.4516129032259], [159.0, 2862.0], [160.0, 465.8333333333333], [161.0, 93.75], [162.0, 496.1666666666667], [163.0, 185.8717948717949], [164.0, 546.3999999999999], [165.0, 542.3125], [166.0, 109.72972972972973], [167.0, 435.5625], [168.0, 192.8888888888889], [169.0, 174.68], [170.0, 237.33333333333331], [171.0, 301.0], [172.0, 756.625], [173.0, 364.5454545454545], [174.0, 123.18867924528301], [175.0, 87.44999999999999], [178.0, 1267.5], [179.0, 99.58333333333333], [180.0, 356.5], [181.0, 211.52631578947367], [182.0, 476.28571428571433], [183.0, 296.0833333333333], [177.0, 2770.0], [184.0, 194.23076923076923], [185.0, 185.9090909090909], [186.0, 495.85714285714283], [187.0, 298.0], [188.0, 89.69999999999999], [189.0, 112.6], [190.0, 841.3], [191.0, 387.6666666666667], [192.0, 388.20000000000005], [193.0, 259.88888888888886], [194.0, 274.3125], [195.0, 373.7], [196.0, 254.99999999999997], [197.0, 337.8461538461538], [198.0, 175.6], [199.0, 190.625], [200.0, 443.65868809011107]], "isOverall": false, "label": "HTTP Request", "isController": false}, {"data": [[195.16624346527263, 446.93256161314497]], "isOverall": false, "label": "HTTP Request-Aggregated", "isController": false}], "supportsControllersDiscrimination": true, "maxX": 200.0, "title": "Time VS Threads"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    axisLabel: "Number of active threads",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average response times in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: { noColumns: 2,show: true, container: '#legendTimeVsThreads' },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s: At %x.2 active threads, Average response time was %y.2 ms"
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesTimeVsThreads"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotTimesVsThreads"), dataset, options);
            // setup overview
            $.plot($("#overviewTimesVsThreads"), dataset, prepareOverviewOptions(options));
        }
};

// Time vs threads
function refreshTimeVsThreads(){
    var infos = timeVsThreadsInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyTimeVsThreads");
        return;
    }
    if(isGraph($("#flotTimesVsThreads"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesTimeVsThreads");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTimesVsThreads", "#overviewTimesVsThreads");
        $('#footerTimeVsThreads .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var bytesThroughputOverTimeInfos = {
        data : {"result": {"minY": 9413.866666666667, "minX": 1.6009758E12, "maxY": 38451.566666666666, "series": [{"data": [[1.6009758E12, 15067.6], [1.60097586E12, 38451.566666666666]], "isOverall": false, "label": "Bytes received per second", "isController": false}, {"data": [[1.6009758E12, 9413.866666666667], [1.60097586E12, 24507.466666666667]], "isOverall": false, "label": "Bytes sent per second", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.60097586E12, "title": "Bytes Throughput Over Time"}},
        getOptions : function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity) ,
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Bytes / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendBytesThroughputOverTime'
                },
                selection: {
                    mode: "xy"
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y"
                }
            };
        },
        createGraph : function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesBytesThroughputOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotBytesThroughputOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewBytesThroughputOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Bytes throughput Over Time
function refreshBytesThroughputOverTime(fixTimestamps) {
    var infos = bytesThroughputOverTimeInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -25200000);
    }
    if(isGraph($("#flotBytesThroughputOverTime"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesBytesThroughputOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotBytesThroughputOverTime", "#overviewBytesThroughputOverTime");
        $('#footerBytesThroughputOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var responseTimesOverTimeInfos = {
        data: {"result": {"minY": 429.50269106566225, "minX": 1.6009758E12, "maxY": 453.62776514368267, "series": [{"data": [[1.6009758E12, 429.50269106566225], [1.60097586E12, 453.62776514368267]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.60097586E12, "title": "Response Time Over Time"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average response time in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimesOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Average response time was %y ms"
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesResponseTimesOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimesOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewResponseTimesOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Response Times Over Time
function refreshResponseTimeOverTime(fixTimestamps) {
    var infos = responseTimesOverTimeInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimeOverTime");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -25200000);
    }
    if(isGraph($("#flotResponseTimesOverTime"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesResponseTimesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimesOverTime", "#overviewResponseTimesOverTime");
        $('#footerResponseTimesOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var latenciesOverTimeInfos = {
        data: {"result": {"minY": 429.4886975242197, "minX": 1.6009758E12, "maxY": 453.61422369237243, "series": [{"data": [[1.6009758E12, 429.4886975242197], [1.60097586E12, 453.61422369237243]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.60097586E12, "title": "Latencies Over Time"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average response latencies in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendLatenciesOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Average latency was %y ms"
                }
            };
        },
        createGraph: function () {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesLatenciesOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotLatenciesOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewLatenciesOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Latencies Over Time
function refreshLatenciesOverTime(fixTimestamps) {
    var infos = latenciesOverTimeInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyLatenciesOverTime");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -25200000);
    }
    if(isGraph($("#flotLatenciesOverTime"))) {
        infos.createGraph();
    }else {
        var choiceContainer = $("#choicesLatenciesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotLatenciesOverTime", "#overviewLatenciesOverTime");
        $('#footerLatenciesOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var connectTimeOverTimeInfos = {
        data: {"result": {"minY": 0.020673971469919332, "minX": 1.6009758E12, "maxY": 0.0828848223896666, "series": [{"data": [[1.6009758E12, 0.0828848223896666], [1.60097586E12, 0.020673971469919332]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.60097586E12, "title": "Connect Time Over Time"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getConnectTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average Connect Time in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendConnectTimeOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Average connect time was %y ms"
                }
            };
        },
        createGraph: function () {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesConnectTimeOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotConnectTimeOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewConnectTimeOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Connect Time Over Time
function refreshConnectTimeOverTime(fixTimestamps) {
    var infos = connectTimeOverTimeInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyConnectTimeOverTime");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -25200000);
    }
    if(isGraph($("#flotConnectTimeOverTime"))) {
        infos.createGraph();
    }else {
        var choiceContainer = $("#choicesConnectTimeOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotConnectTimeOverTime", "#overviewConnectTimeOverTime");
        $('#footerConnectTimeOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var responseTimePercentilesOverTimeInfos = {
        data: {"result": {"minY": 0.0, "minX": 1.6009758E12, "maxY": 3243.0, "series": [{"data": [[1.6009758E12, 2524.0], [1.60097586E12, 3243.0]], "isOverall": false, "label": "Max", "isController": false}, {"data": [[1.6009758E12, 13.0], [1.60097586E12, 16.0]], "isOverall": false, "label": "90th percentile", "isController": false}, {"data": [[1.6009758E12, 14.135000348091125], [1.60097586E12, 16.0]], "isOverall": false, "label": "99th percentile", "isController": false}, {"data": [[1.6009758E12, 13.0], [1.60097586E12, 16.0]], "isOverall": false, "label": "95th percentile", "isController": false}, {"data": [[1.6009758E12, 2.0], [1.60097586E12, 0.0]], "isOverall": false, "label": "Min", "isController": false}, {"data": [[1.6009758E12, 103.0], [1.60097586E12, 129.0]], "isOverall": false, "label": "Median", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.60097586E12, "title": "Response Time Percentiles Over Time (successful requests only)"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true,
                        fill: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Response Time in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimePercentilesOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Response time was %y ms"
                }
            };
        },
        createGraph: function () {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesResponseTimePercentilesOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimePercentilesOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewResponseTimePercentilesOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Response Time Percentiles Over Time
function refreshResponseTimePercentilesOverTime(fixTimestamps) {
    var infos = responseTimePercentilesOverTimeInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -25200000);
    }
    if(isGraph($("#flotResponseTimePercentilesOverTime"))) {
        infos.createGraph();
    }else {
        var choiceContainer = $("#choicesResponseTimePercentilesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimePercentilesOverTime", "#overviewResponseTimePercentilesOverTime");
        $('#footerResponseTimePercentilesOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var responseTimeVsRequestInfos = {
    data: {"result": {"minY": 87.0, "minX": 70.0, "maxY": 3608.5, "series": [{"data": [[530.0, 129.0], [701.0, 120.0], [676.0, 141.0], [677.0, 148.0], [702.0, 132.0], [732.0, 133.0], [770.0, 126.0], [831.0, 105.0], [922.0, 93.0], [932.0, 89.0], [70.0, 1568.0], [112.0, 2916.5], [145.0, 353.0], [144.0, 101.0], [168.0, 180.0], [199.0, 137.0], [210.0, 93.0], [217.0, 162.0], [238.0, 262.5], [258.0, 91.0], [270.0, 120.0], [282.0, 87.0], [317.0, 122.0], [348.0, 88.0], [366.0, 108.0], [362.0, 203.0], [371.0, 138.0], [439.0, 157.5], [436.0, 218.0], [460.0, 114.0], [505.0, 183.0]], "isOverall": false, "label": "Successes", "isController": false}, {"data": [[530.0, 1096.0], [145.0, 1258.0], [168.0, 1399.5], [702.0, 1402.0], [732.0, 2817.0], [770.0, 2363.5], [199.0, 1343.5], [217.0, 1124.5], [238.0, 1784.0], [258.0, 1297.0], [270.0, 2544.0], [282.0, 1425.0], [317.0, 1879.0], [348.0, 1783.0], [366.0, 1404.0], [362.0, 1952.5], [371.0, 1756.5], [439.0, 2598.0], [436.0, 3608.5], [460.0, 1405.0], [112.0, 2745.5], [505.0, 1023.0]], "isOverall": false, "label": "Failures", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 1000, "maxX": 932.0, "title": "Response Time Vs Request"}},
    getOptions: function() {
        return {
            series: {
                lines: {
                    show: false
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                axisLabel: "Global number of requests per second",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Median Response Time in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendResponseTimeVsRequest'
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : Median response time at %x req/s was %y ms"
            },
            colors: ["#9ACD32", "#FF6347"]
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesResponseTimeVsRequest"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotResponseTimeVsRequest"), dataset, options);
        // setup overview
        $.plot($("#overviewResponseTimeVsRequest"), dataset, prepareOverviewOptions(options));

    }
};

// Response Time vs Request
function refreshResponseTimeVsRequest() {
    var infos = responseTimeVsRequestInfos;
    prepareSeries(infos.data);
    if (isGraph($("#flotResponseTimeVsRequest"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesResponseTimeVsRequest");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimeVsRequest", "#overviewResponseTimeVsRequest");
        $('#footerResponseRimeVsRequest .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var latenciesVsRequestInfos = {
    data: {"result": {"minY": 87.0, "minX": 70.0, "maxY": 3607.5, "series": [{"data": [[530.0, 129.0], [701.0, 120.0], [676.0, 141.0], [677.0, 148.0], [702.0, 132.0], [732.0, 133.0], [770.0, 126.0], [831.0, 105.0], [922.0, 93.0], [932.0, 89.0], [70.0, 1568.0], [112.0, 2916.5], [145.0, 353.0], [144.0, 101.0], [168.0, 180.0], [199.0, 137.0], [210.0, 93.0], [217.0, 162.0], [238.0, 262.5], [258.0, 91.0], [270.0, 120.0], [282.0, 87.0], [317.0, 122.0], [348.0, 88.0], [366.0, 108.0], [362.0, 203.0], [371.0, 138.0], [439.0, 157.5], [436.0, 218.0], [460.0, 114.0], [505.0, 183.0]], "isOverall": false, "label": "Successes", "isController": false}, {"data": [[530.0, 1096.0], [145.0, 1258.0], [168.0, 1399.5], [702.0, 1401.0], [732.0, 2816.0], [770.0, 2363.0], [199.0, 1343.0], [217.0, 1124.5], [238.0, 1783.5], [258.0, 1297.0], [270.0, 2544.0], [282.0, 1425.0], [317.0, 1879.0], [348.0, 1783.0], [366.0, 1404.0], [362.0, 1952.5], [371.0, 1756.5], [439.0, 2598.0], [436.0, 3607.5], [460.0, 1404.0], [112.0, 2745.5], [505.0, 1023.0]], "isOverall": false, "label": "Failures", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 1000, "maxX": 932.0, "title": "Latencies Vs Request"}},
    getOptions: function() {
        return{
            series: {
                lines: {
                    show: false
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                axisLabel: "Global number of requests per second",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Median Latency in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: { noColumns: 2,show: true, container: '#legendLatencyVsRequest' },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : Median Latency time at %x req/s was %y ms"
            },
            colors: ["#9ACD32", "#FF6347"]
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesLatencyVsRequest"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotLatenciesVsRequest"), dataset, options);
        // setup overview
        $.plot($("#overviewLatenciesVsRequest"), dataset, prepareOverviewOptions(options));
    }
};

// Latencies vs Request
function refreshLatenciesVsRequest() {
        var infos = latenciesVsRequestInfos;
        prepareSeries(infos.data);
        if(isGraph($("#flotLatenciesVsRequest"))){
            infos.createGraph();
        }else{
            var choiceContainer = $("#choicesLatencyVsRequest");
            createLegend(choiceContainer, infos);
            infos.createGraph();
            setGraphZoomable("#flotLatenciesVsRequest", "#overviewLatenciesVsRequest");
            $('#footerLatenciesVsRequest .legendColorBox > div').each(function(i){
                $(this).clone().prependTo(choiceContainer.find("li").eq(i));
            });
        }
};

var hitsPerSecondInfos = {
        data: {"result": {"minY": 65.26666666666667, "minX": 1.6009758E12, "maxY": 157.9, "series": [{"data": [[1.6009758E12, 65.26666666666667], [1.60097586E12, 157.9]], "isOverall": false, "label": "hitsPerSecond", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.60097586E12, "title": "Hits Per Second"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of hits / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendHitsPerSecond"
                },
                selection: {
                    mode : 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y.2 hits/sec"
                }
            };
        },
        createGraph: function createGraph() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesHitsPerSecond"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotHitsPerSecond"), dataset, options);
            // setup overview
            $.plot($("#overviewHitsPerSecond"), dataset, prepareOverviewOptions(options));
        }
};

// Hits per second
function refreshHitsPerSecond(fixTimestamps) {
    var infos = hitsPerSecondInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -25200000);
    }
    if (isGraph($("#flotHitsPerSecond"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesHitsPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotHitsPerSecond", "#overviewHitsPerSecond");
        $('#footerHitsPerSecond .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var codesPerSecondInfos = {
        data: {"result": {"minY": 1.1166666666666667, "minX": 1.6009758E12, "maxY": 158.35, "series": [{"data": [[1.6009758E12, 60.81666666666667], [1.60097586E12, 158.35]], "isOverall": false, "label": "200", "isController": false}, {"data": [[1.6009758E12, 1.1166666666666667], [1.60097586E12, 2.8833333333333333]], "isOverall": false, "label": "500", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.60097586E12, "title": "Codes Per Second"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of responses / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendCodesPerSecond"
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "Number of Response Codes %s at %x was %y.2 responses / sec"
                }
            };
        },
    createGraph: function() {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesCodesPerSecond"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotCodesPerSecond"), dataset, options);
        // setup overview
        $.plot($("#overviewCodesPerSecond"), dataset, prepareOverviewOptions(options));
    }
};

// Codes per second
function refreshCodesPerSecond(fixTimestamps) {
    var infos = codesPerSecondInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -25200000);
    }
    if(isGraph($("#flotCodesPerSecond"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesCodesPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotCodesPerSecond", "#overviewCodesPerSecond");
        $('#footerCodesPerSecond .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var transactionsPerSecondInfos = {
        data: {"result": {"minY": 1.1166666666666667, "minX": 1.6009758E12, "maxY": 158.35, "series": [{"data": [[1.6009758E12, 60.81666666666667], [1.60097586E12, 158.35]], "isOverall": false, "label": "HTTP Request-success", "isController": false}, {"data": [[1.6009758E12, 1.1166666666666667], [1.60097586E12, 2.8833333333333333]], "isOverall": false, "label": "HTTP Request-failure", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.60097586E12, "title": "Transactions Per Second"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of transactions / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendTransactionsPerSecond"
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y transactions / sec"
                }
            };
        },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesTransactionsPerSecond"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotTransactionsPerSecond"), dataset, options);
        // setup overview
        $.plot($("#overviewTransactionsPerSecond"), dataset, prepareOverviewOptions(options));
    }
};

// Transactions per second
function refreshTransactionsPerSecond(fixTimestamps) {
    var infos = transactionsPerSecondInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyTransactionsPerSecond");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -25200000);
    }
    if(isGraph($("#flotTransactionsPerSecond"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesTransactionsPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTransactionsPerSecond", "#overviewTransactionsPerSecond");
        $('#footerTransactionsPerSecond .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var totalTPSInfos = {
        data: {"result": {"minY": 1.1166666666666667, "minX": 1.6009758E12, "maxY": 158.35, "series": [{"data": [[1.6009758E12, 60.81666666666667], [1.60097586E12, 158.35]], "isOverall": false, "label": "Transaction-success", "isController": false}, {"data": [[1.6009758E12, 1.1166666666666667], [1.60097586E12, 2.8833333333333333]], "isOverall": false, "label": "Transaction-failure", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.60097586E12, "title": "Total Transactions Per Second"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of transactions / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendTotalTPS"
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y transactions / sec"
                },
                colors: ["#9ACD32", "#FF6347"]
            };
        },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesTotalTPS"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotTotalTPS"), dataset, options);
        // setup overview
        $.plot($("#overviewTotalTPS"), dataset, prepareOverviewOptions(options));
    }
};

// Total Transactions per second
function refreshTotalTPS(fixTimestamps) {
    var infos = totalTPSInfos;
    // We want to ignore seriesFilter
    prepareSeries(infos.data, false, true);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -25200000);
    }
    if(isGraph($("#flotTotalTPS"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesTotalTPS");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTotalTPS", "#overviewTotalTPS");
        $('#footerTotalTPS .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

// Collapse the graph matching the specified DOM element depending the collapsed
// status
function collapse(elem, collapsed){
    if(collapsed){
        $(elem).parent().find(".fa-chevron-up").removeClass("fa-chevron-up").addClass("fa-chevron-down");
    } else {
        $(elem).parent().find(".fa-chevron-down").removeClass("fa-chevron-down").addClass("fa-chevron-up");
        if (elem.id == "bodyBytesThroughputOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshBytesThroughputOverTime(true);
            }
            document.location.href="#bytesThroughputOverTime";
        } else if (elem.id == "bodyLatenciesOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshLatenciesOverTime(true);
            }
            document.location.href="#latenciesOverTime";
        } else if (elem.id == "bodyCustomGraph") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshCustomGraph(true);
            }
            document.location.href="#responseCustomGraph";
        } else if (elem.id == "bodyConnectTimeOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshConnectTimeOverTime(true);
            }
            document.location.href="#connectTimeOverTime";
        } else if (elem.id == "bodyResponseTimePercentilesOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimePercentilesOverTime(true);
            }
            document.location.href="#responseTimePercentilesOverTime";
        } else if (elem.id == "bodyResponseTimeDistribution") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimeDistribution();
            }
            document.location.href="#responseTimeDistribution" ;
        } else if (elem.id == "bodySyntheticResponseTimeDistribution") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshSyntheticResponseTimeDistribution();
            }
            document.location.href="#syntheticResponseTimeDistribution" ;
        } else if (elem.id == "bodyActiveThreadsOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshActiveThreadsOverTime(true);
            }
            document.location.href="#activeThreadsOverTime";
        } else if (elem.id == "bodyTimeVsThreads") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTimeVsThreads();
            }
            document.location.href="#timeVsThreads" ;
        } else if (elem.id == "bodyCodesPerSecond") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshCodesPerSecond(true);
            }
            document.location.href="#codesPerSecond";
        } else if (elem.id == "bodyTransactionsPerSecond") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTransactionsPerSecond(true);
            }
            document.location.href="#transactionsPerSecond";
        } else if (elem.id == "bodyTotalTPS") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTotalTPS(true);
            }
            document.location.href="#totalTPS";
        } else if (elem.id == "bodyResponseTimeVsRequest") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimeVsRequest();
            }
            document.location.href="#responseTimeVsRequest";
        } else if (elem.id == "bodyLatenciesVsRequest") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshLatenciesVsRequest();
            }
            document.location.href="#latencyVsRequest";
        }
    }
}

/*
 * Activates or deactivates all series of the specified graph (represented by id parameter)
 * depending on checked argument.
 */
function toggleAll(id, checked){
    var placeholder = document.getElementById(id);

    var cases = $(placeholder).find(':checkbox');
    cases.prop('checked', checked);
    $(cases).parent().children().children().toggleClass("legend-disabled", !checked);

    var choiceContainer;
    if ( id == "choicesBytesThroughputOverTime"){
        choiceContainer = $("#choicesBytesThroughputOverTime");
        refreshBytesThroughputOverTime(false);
    } else if(id == "choicesResponseTimesOverTime"){
        choiceContainer = $("#choicesResponseTimesOverTime");
        refreshResponseTimeOverTime(false);
    }else if(id == "choicesResponseCustomGraph"){
        choiceContainer = $("#choicesResponseCustomGraph");
        refreshCustomGraph(false);
    } else if ( id == "choicesLatenciesOverTime"){
        choiceContainer = $("#choicesLatenciesOverTime");
        refreshLatenciesOverTime(false);
    } else if ( id == "choicesConnectTimeOverTime"){
        choiceContainer = $("#choicesConnectTimeOverTime");
        refreshConnectTimeOverTime(false);
    } else if ( id == "choicesResponseTimePercentilesOverTime"){
        choiceContainer = $("#choicesResponseTimePercentilesOverTime");
        refreshResponseTimePercentilesOverTime(false);
    } else if ( id == "choicesResponseTimePercentiles"){
        choiceContainer = $("#choicesResponseTimePercentiles");
        refreshResponseTimePercentiles();
    } else if(id == "choicesActiveThreadsOverTime"){
        choiceContainer = $("#choicesActiveThreadsOverTime");
        refreshActiveThreadsOverTime(false);
    } else if ( id == "choicesTimeVsThreads"){
        choiceContainer = $("#choicesTimeVsThreads");
        refreshTimeVsThreads();
    } else if ( id == "choicesSyntheticResponseTimeDistribution"){
        choiceContainer = $("#choicesSyntheticResponseTimeDistribution");
        refreshSyntheticResponseTimeDistribution();
    } else if ( id == "choicesResponseTimeDistribution"){
        choiceContainer = $("#choicesResponseTimeDistribution");
        refreshResponseTimeDistribution();
    } else if ( id == "choicesHitsPerSecond"){
        choiceContainer = $("#choicesHitsPerSecond");
        refreshHitsPerSecond(false);
    } else if(id == "choicesCodesPerSecond"){
        choiceContainer = $("#choicesCodesPerSecond");
        refreshCodesPerSecond(false);
    } else if ( id == "choicesTransactionsPerSecond"){
        choiceContainer = $("#choicesTransactionsPerSecond");
        refreshTransactionsPerSecond(false);
    } else if ( id == "choicesTotalTPS"){
        choiceContainer = $("#choicesTotalTPS");
        refreshTotalTPS(false);
    } else if ( id == "choicesResponseTimeVsRequest"){
        choiceContainer = $("#choicesResponseTimeVsRequest");
        refreshResponseTimeVsRequest();
    } else if ( id == "choicesLatencyVsRequest"){
        choiceContainer = $("#choicesLatencyVsRequest");
        refreshLatenciesVsRequest();
    }
    var color = checked ? "black" : "#818181";
    if(choiceContainer != null) {
        choiceContainer.find("label").each(function(){
            this.style.color = color;
        });
    }
}

