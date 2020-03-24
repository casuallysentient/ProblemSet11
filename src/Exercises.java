import java.util.ArrayList;
//1
public class Exercises {
    public int findMe(int[] list, int target) {
        if (list == null || list.length == 0) {
            return -1;
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target) {
                return i;
            }
        }
        return -1;
    }
//2
    public int findMe(ArrayList<String> list, String target) {
        if (list == null || list.isEmpty() == true) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }
//3
    public int findMeFaster(ArrayList<Integer> list, int target) {
        if (list == null || list.size() == 0) {
            return -1;
        }
        int start = 0;
        int mid = 0;
        int end = list.size() - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (list.get(mid) > target) {
                end = mid - 1;
            } else if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
//4
    public int findMeFaster(String[] list, String target) {
        if (list == null || list.length == 0) {
            return -1;
        }
        int start = 0;
        int mid = 0;
        int end = list.length - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            mid = ((start + end) / 2);
            if (list[mid].compareTo(target) < 0) {
                start = mid + 1;
            } else if (list[mid].compareTo(target) > 0) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
//5
    public int[] bubble(int[] list, boolean ascending) {
        if (list == null || list.length == 0) {
			return null;
		}
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j] > list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
		if (!ascending) {
			int i, t;
			int n = list.length;
			for (i = 0; i < n / 2; i++) {
				t = list[i];
				list[i] = list[n - i - 1];
				list[n - i - 1] = t;
			}
		}

		return list;
    }
//6
    public ArrayList<String> bubble(ArrayList<String> list, boolean ascending) {
        if (list.contains(null) || list == null) {
			return null;
		}
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    String temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
		if (!ascending) {
			Collections.reverse(list);
		}
		return list;
    }
//7
    public ArrayList<Integer> insertion(ArrayList<Integer> list, boolean ascending) {
        if (list == null) {
            return null;
        }

        int cuantosNulls = 0;
        ArrayList<String> newList = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                cuantosNulls++;
            } else {
                newList.add(list.get(i));
            }
        }
        if (ascending) {
            int lastIndex = newList.size() - 1;
            boolean switched = true;
            while (switched) {
                switched = false;
                for (int i = 0; i < lastIndex; i++) {
                    if (newList.get(i) == null) {
                        newList.add(newList.remove(i));
                    } else {
                        if (newList.get(i).compareTo(newList.get(i + 1)) > 0) {
                            String temp = newList.get(i);
                            newList.set(i, newList.get(i + 1));
                            newList.set(i + 1, temp);
                            switched = true;
                        }
                    }
                }
                lastIndex--;
            }
        } else {
            int lastIndex = newList.size() - 1;
            boolean switched = true;
            while (switched) {
                switched = false;
                for (int i = 0; i < lastIndex; i++) {
                    if (newList.get(i) == null) {
                        newList.add(newList.remove(i));
                    } else {
                        if (newList.get(i).compareTo(newList.get(i + 1)) < 0) {
                            String temp = newList.get(i);
                            newList.set(i, newList.get(i + 1));
                            newList.set(i + 1, temp);
                            switched = true;
                        }
                    }
                }
                lastIndex--;
            }
        }
        for (int i = 0; i < cuantosNulls; i++) {
            newList.add(null);
        }
        return newList;
    }
//8
    public String[] insertion(String[] list, boolean ascending) {
        if (list == null) {
            return null;
        }
        int cuantosNulls = 0;
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                cuantosNulls++;
            } else {
                newList.add(list.get(i));
            }
        }
        if (ascending) {
            int i = 0;
            while (i < newList.size()) {
                int j = i;
                while (j > 0 && newList.get(j - 1) > newList.get(j)) {
                    int temp = newList.get(j - 1);
                    newList.set((j - 1), newList.get(j));
                    newList.set(j , temp);
                    j--;
                }
                i++;
            }
        } else {
            int i = 0;
            while (i < newList.size()) {
                int j = i;
                while (j > 0 && newList.get(j - 1) < newList.get(j)) {
                    int temp = newList.get(j - 1);
                    newList.set((j - 1), newList.get(j));
                    newList.set(j , temp);
                    j--;
                }
                i++;
            }
        }
        for (int i = 0; i < cuantosNulls; i++) {
            newList.add(null);
        }
        return newList;
    }
//9
    public int[] selection(int[] list, boolean ascending) {
        if (list == null || list.length == 0) {
            return null;
        }
        for (int i = 0; i < list.length; i++) {
            int minOrMax = list[i];
            int index = i;
            for (int j = i; j < list.length; j++) {
                if ((ascending && minOrMax > list[j]) || (!ascending && minOrMax < list[j])) {
                    minOrMax = list[j];
                    index = j;
                }
            }

            int temp = list[i];
            list[i] = list[index];
            list[index] = temp;
        }

        return list;
    }
//10
    public ArrayList<String> selection(ArrayList<String> list, boolean ascending) {
        if (list == null || list.size() == 0) {
            return null;
        }

        for (int i = 0; i < list.size(); i++) {
            String minOrMax = list.get(i);
            int index = i;
            for (int j = i; j < list.size(); j++) {
                if ((ascending && minOrMax.compareTo(list.get(j)) > 0) || (!ascending && minOrMax.compareTo(list.get(j)) < 0)) {
                    minOrMax = list.get(j);
                    index = j;
                }
            }

            String temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }

        return list;
    }
//11
    public ArrayList<Integer> merge(ArrayList<Integer> list, boolean ascending) {
        if (list == null || list.size() == 0) {return null;}

        if (list.size() > 1) {
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            for (int i = 0; i < list.size() / 2; i++) {
                list1.add(list.get(i));
            }

            ArrayList<Integer> list2 = new ArrayList<Integer>();
            for (int i = list.size() / 2; i < list.size(); i++) {
                list2.add(list.get(i));
            }
            list1 = merge(list1, ascending);
            list2 = merge(list2, ascending);
            for (int i = 0; i < list.size(); i++) {
                if (ascending) {
                    if (list1.size() == 0) {
                        list.set(i, list2.get(0));
                        list2.remove(0);
                    } else if (list2.size() == 0 || list1.get(0) < list2.get(0)) {
                        list.set(i, list1.get(0));
                        list1.remove(0);
                    } else {
                        list.set(i, list2.get(0));
                        list2.remove(0);
                    }
                } else if (!ascending) {
                    if (list1.size() == 0) {
                        list.set(i, list2.get(0));
                        list2.remove(0);
                    } else if (list2.size() == 0 || list1.get(0) > list2.get(0)) {
                        list.set(i, list1.get(0));
                        list1.remove(0);
                    } else {
                        list.set(i, list2.get(0));
                        list2.remove(0);
                    }
                }
            }
        }
        return list;
    }
//11.5
    public String[] combine(String[] firstList, String[] secondList, boolean ascending) {
        String[] combination = new String[firstList.length + secondList.length];
        int firstLocation = 0;
        int secondLocation = 0;
        int combineLocation = 0;

        while (firstLocation < firstList.length && secondLocation < secondList.length) {
            if (ascending) {
                if (firstList[firstLocation].compareTo(secondList[secondLocation]) < 0) {
                    combination[combineLocation] = firstList[firstLocation];
                    firstLocation++;
                    combineLocation++;
                } else {
                    combination[combineLocation] = secondList[secondLocation];
                    secondLocation++;
                    combineLocation++;
                }
            } else {
                if (firstList[firstLocation].compareTo(secondList[secondLocation]) > 0) {
                    combination[combineLocation] = firstList[firstLocation];
                    firstLocation++;
                    combineLocation++;
                } else {
                    combination[combineLocation] = secondList[secondLocation];
                    secondLocation++;
                    combineLocation++;
                }
            }
        }
        while (firstLocation == firstList.length && secondLocation != secondList.length) {
            combination[combineLocation] = secondList[secondLocation];
            secondLocation++;
            combineLocation++;
        }
        while (secondLocation == secondList.length && firstLocation != firstList.length) {
            combination[combineLocation] = firstList[firstLocation];
            firstLocation++;
            combineLocation++;
        }
        return combination;
    }
//12
    public String[] merge(String[] list, boolean ascending) {
        return null;
    }
}
