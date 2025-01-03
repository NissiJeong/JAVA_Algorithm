//package programers;
//
//import java.util.*;
//import java.util.stream.IntStream;
//
//public class QuickSort {
//
//    public int[][] solution3(int[][] data, String ext, int val_ext, String sort_by){
//        String[] arr = {"code", "date", "maximum", "remain"};
//        List<String> columnList = Arrays.asList(arr);
//        int extIdx = columnList.indexOf(ext);
//        int sorIdx = columnList.indexOf(sort_by);
//        int[][] answer = Arrays.stream(data).filter(o1 -> o1[extIdx] < val_ext)
//                .sorted((o1, o2) -> o1[sorIdx] - o2[sorIdx]).toArray(int[][]::new);
//
//        int[][] answer2 = Arrays.stream(data).filter(o1 -> o1[sorIdx] < val_ext).sorted((o1, o2) -> o1[sorIdx] - o1[sorIdx]).toArray(int[][]::new);
//
//        return answer;
//    }
//
//    public int[] solution2(String s){
//        return IntStream.range(0, s.length()).map(i -> s.substring(0, i).lastIndexOf(s.charAt(i)) > -1 ? i - s.substring(0, i).lastIndexOf(s.charAt(i)) : -1).toArray();
//    }
//
//    public int[] solution5(String s){
//        return IntStream.range(0, s.length()).map(i -> s.substring(0, i).lastIndexOf(s.charAt(i)) > -1 ? i - s.substring(0, i).lastIndexOf(s.charAt(i)) : -1).toArray();
//    }
//
//    public int[] solution6(List<Integer> list){
//        return list.stream().mapToInt(Integer::intValue).toArray();
//    }
//
//    public int[] solution3(String s) {
//        int[] answer = new int[s.length()];
//        HashMap<Character,Integer> map = new HashMap<>();
//        for(int i=0; i<s.length();i++){
//            char ch = s.charAt(i);
//            answer[i] = i-map.getOrDefault(ch,i+1);
//            map.put(ch,i);
//        }
//        return answer;
//    }
//
//    public int[][] solution2(int[][] data, String ext, int val_ext, String sort_by) {
//
//        String[] arr = {"code","date","maximum","remain"};
//        List<String> columnList = Arrays.asList(arr);
//        int extIdx = columnList.indexOf(ext);
//        int sortIdx = columnList.indexOf(sort_by);
//        int[][] answer = Arrays.stream(data).filter(o1 -> o1[extIdx] < val_ext)
//            .sorted((o1 ,o2) -> o1[sortIdx]-o2[sortIdx]).toArray(int[][]::new);
//
//        return answer;
//    }
//
//    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
//        int[][] answer = {};
//        List<int[]> list1 = new ArrayList();
//
//        Map<String, Integer> map = Map.of("code", 0, "date", 1, "maximum", 2, "remain", 3);
//
//        int extIdx = map.get(ext);
//        int sortIdx = map.get(sort_by);
//
//        for(int i=0; i<data.length; i++){
//            if(data[i][extIdx] < val_ext){
//                list1.add(data[i]);
//            }
//        }
//
//        answer = list1.toArray(new int[list1.size()][4]);
//
//        quickSort(answer, 0, answer.length-1, sortIdx);
//
//        return answer;
//    }
//
//    void quickSort(int[][] arr, int left, int right, int sortIdx) {
//        int part = partition(arr, left, right, sortIdx);
//        if (left < part - 1) {
//            quickSort(arr, left, part - 1, sortIdx);
//        }
//        if (part < right) {
//            quickSort(arr, part, right, sortIdx);
//        }
//    }
//
//    void quickSort2(int[] arr, int left, int right){
//        int part = partition2(arr, left, right);
//        if(left < part - 1)
//            quickSort2(arr, left, part-1);
//        if(part < right)
//            quickSort2(arr, part, right);
//    }
//
//    int partition2(int[] arr, int left, int right){
//        int pivot = arr[(left+right)/2];
//        while(left <= right){
//            while(arr[left] < pivot){
//                left++;
//            }
//            while(arr[right] > pivot){
//                right--;
//            }
//            if(left <= right){
//                swap2(arr, left, right);
//                left++;
//                right--;
//            }
//        }
//
//        return left;
//    }
//
//    void swap2(int[] arr, int left, int right){
//        int temp = arr[left];
//        arr[left] = arr[right];
//        arr[right] = temp;
//    }
//
//    int partition(int[][] arr, int left, int right, int sortIdx) {
//        int pivot = arr[(left + right) / 2][sortIdx];
//        while (left <= right) { // 해당 부분 배열에 대해 반복
//            while (arr[left][sortIdx] < pivot) { //피벗보다 큰 left를 찾음
//                left++;
//            }
//            while (arr[right][sortIdx] > pivot) { //피벗보다 작은 right를 찾음
//                right--;
//            }
//            if (left <= right) { //left가 right보다 왼쪽에 있으면 둘이 자리 바꿈
//                swap(arr, left, right);
//                left++;
//                right--;
//            }
//        }
//        return left;
//    }
//
//    void swap(int[][] arr, int left, int right){
//        int[] temp = arr[left];
//        arr[left] = arr[right];
//        arr[right] = temp;
//    }
//}
