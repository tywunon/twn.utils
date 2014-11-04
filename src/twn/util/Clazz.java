package twn.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public final class Clazz {
	public final static Set<Field> getAllFields(Class<?> clazz) {
		Set<Field> fields = new HashSet<Field>();
		while (clazz != null) {
			fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		return fields;
	}

	public final static boolean hasField(Class<?> clazz, String fieldName) {
		Set<Field> fields = getAllFields(clazz);
		for (Field f : fields) {
			if (f.getName().equals(fieldName))
				return true;
		}
		return false;
	}

	private final static String stripFilenameExtension(String filename) {
		int i = filename.lastIndexOf('.');
		if (i > 0) {
			return filename.substring(0, i);
		} else {
			return filename;
		}
	}

	final static Set<Class<?>> getFromDirectory(File directory, String packageName) {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		if (directory.exists()) {
			for (String file : directory.list()) {
				if (file.endsWith(".class")) {
					String name = packageName + '.'
							+ stripFilenameExtension(file);
					Class<?> clazz;
					try {
						clazz = Class.forName(name);
						classes.add(clazz);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return classes;
	}

	final static Set<Class<?>> getFromJARFile(String jar, String packageName) {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		JarInputStream jarFile = null;
		try {
			jarFile = new JarInputStream(new FileInputStream(jar));
			JarEntry jarEntry;
			do {
				jarEntry = jarFile.getNextJarEntry();
				if (jarEntry != null) {
					String className = jarEntry.getName();
					if (className.endsWith(".class")) {
						className = stripFilenameExtension(className);
						if (className.startsWith(packageName))
							classes.add(Class.forName(className.replace('/', '.')));
					}
				}
			} while (jarEntry != null);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(jarFile != null){
				try {
					jarFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return classes;
	}

	public final static Set<Class<?>> getClassesOfPackage(String packageName,
			boolean includeSubPackages) {
		//Set of found Classes
		Set<Class<?>> classes = new HashSet<Class<?>>();
		
		//if packageName ends with .* all subpackages will be searched, indifferent of the includeSubPackages Value
		if(packageName.endsWith(".*")) {
			includeSubPackages = true;
			packageName = packageName.replace(".*", "");
		}
		
		//find all Matching Packages includeing the Subpackages
		Set<Package> matchingPackages = new HashSet<>();
		Package[] allPackages = Package.getPackages();
		for(Package pack :  allPackages){
			if((includeSubPackages && pack.getName().startsWith(packageName)) || (!includeSubPackages && pack.getName().equals(packageName))){
				matchingPackages.add(pack);
			}
		}
		
		for(Package pack : matchingPackages) {
			String path = pack.getName().replace('.', '/');
			Enumeration<URL> resources;
			try {
				resources = Thread.currentThread()
						.getContextClassLoader().getResources(path);
				if (resources != null) {
					while (resources.hasMoreElements()) {
						String filePath = resources.nextElement().getFile();
						// WINDOWS HACK
						if (filePath.indexOf("%20") > 0)
							filePath = filePath.replaceAll("%20", " ");
						if (filePath != null) {
							if ((filePath.indexOf("!") > 0)
									& (filePath.indexOf(".jar") > 0)) {
								String jarPath = filePath.substring(0,
										filePath.indexOf("!")).substring(
												filePath.indexOf(":") + 1);
								// WINDOWS HACK
								if (jarPath.indexOf(":") >= 0)
									jarPath = jarPath.substring(1);
								classes.addAll(getFromJARFile(jarPath, path));
							} else {
								classes.addAll(getFromDirectory(new File(filePath),
										pack.getName()));
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return classes;
	}

	public final static Set<Class<?>> getClassesOfPackage(Package _package,
			boolean includeSubPackages) {
		return getClassesOfPackage(_package.getName(), includeSubPackages);
	}

	public final static Set<Class<?>> getClassesOfPackage(String packageName) {
		return getClassesOfPackage(packageName, packageName.endsWith(".*"));
	}

	public final static Set<Class<?>> getClassesOfPackage(Package _package) {
		return getClassesOfPackage(_package.getName());
	}
}
