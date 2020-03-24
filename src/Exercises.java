import java.util.ArrayList;

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

        for (int i = 0; i < cuantosNulls; i++) {
            newList.add(null);
        }

        return newList;
    }

    public int[] selection(int[] list, boolean ascending) {
        return null;
    }

    public ArrayList<String> selection(ArrayList<String> list, boolean ascending) {
        return null;
    }

    public ArrayList<Integer> merge(ArrayList<Integer> list, boolean ascending) {
        return null;
    }

    public String[] merge(String[] list, boolean ascending) {
        return null;
    }
}
