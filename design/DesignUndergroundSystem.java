package leetcode.design;

import java.util.HashMap;

/* https://leetcode.com/problems/design-underground-system */
/* Runtime: 85 ms, faster than 94.88% */
public class DesignUndergroundSystem {
    class UndergroundSystem {

        class TransferInfo {
            String startStation;
            String endStation;

            public TransferInfo(String startStation, String endStation) {
                this.startStation = startStation;
                this.endStation = endStation;
            }

            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((endStation == null) ? 0
                        : endStation.hashCode() + ((startStation == null) ? 0 : startStation.hashCode()));
                return result;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)
                    return true;
                if (obj == null)
                    return false;
                if (getClass() != obj.getClass())
                    return false;
                TransferInfo other = (TransferInfo) obj;
                if (endStation == null) {
                    if (other.endStation != null)
                        return false;
                } else if (!endStation.equals(other.endStation))
                    return false;
                if (startStation == null) {
                    if (other.startStation != null)
                        return false;
                } else if (!startStation.equals(other.startStation))
                    return false;
                return true;
            }

        }

        class TransferData {
            long time;
            int count;

            public TransferData(long time, int count) {
                this.time = time;
                this.count = count;
            }

            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + count;
                result = prime * result + (int) (time ^ (time >>> 32));
                return result;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)
                    return true;
                if (obj == null)
                    return false;
                if (getClass() != obj.getClass())
                    return false;
                TransferData other = (TransferData) obj;
                if (count != other.count)
                    return false;
                if (time != other.time)
                    return false;
                return true;
            }
        }

        class CheckinData {
            String station;
            int time;

            public CheckinData(String station, int time) {
                this.station = station;
                this.time = time;
            }

            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((station == null) ? 0 : station.hashCode());
                result = prime * result + time;
                return result;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)
                    return true;
                if (obj == null)
                    return false;
                if (getClass() != obj.getClass())
                    return false;
                CheckinData other = (CheckinData) obj;
                if (station == null) {
                    if (other.station != null)
                        return false;
                } else if (!station.equals(other.station))
                    return false;
                if (time != other.time)
                    return false;
                return true;
            }
        }

        HashMap<Integer, CheckinData> idToCheckinData = new HashMap<>();
        HashMap<TransferInfo, TransferData> transferInfoTotransferData = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            idToCheckinData.put(id, new CheckinData(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            String fromStation = idToCheckinData.get(id).station;
            int startTime = idToCheckinData.get(id).time;
            int diffTime = t - startTime;

            TransferInfo transferInfo = new TransferInfo(fromStation, stationName);
            TransferData transferData = transferInfoTotransferData.get(transferInfo);
            if (transferData == null) {
                transferData = new TransferData(0, 0);
            }
            transferData.count++;
            transferData.time += diffTime;
            transferInfoTotransferData.put(transferInfo, transferData);
        }

        public double getAverageTime(String startStation, String endStation) {
            TransferData transferData = transferInfoTotransferData.get(new TransferInfo(startStation, endStation));
            return transferData == null ? 0 : (double) ((double) transferData.time / (double) transferData.count);
        }
    }
}
